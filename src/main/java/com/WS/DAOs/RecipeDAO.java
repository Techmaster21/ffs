/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WS.DAOs;

import com.WS.Beans.Recipe;
import com.WS.ClientBeans.ClientRecipe;
import com.WS.SessionFactoryFactory;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Eric
 */
public class RecipeDAO {

    private final SessionFactory factory = SessionFactoryFactory.getSessionFactory();
    private final Session session;

    public RecipeDAO() {
        session = factory.openSession();
        session.beginTransaction();
    }

    public void saveRecipe(Recipe recipe) {
        this.session.persist(recipe);
        this.session.flush();
        this.session.getTransaction().commit();
    }
    
    public ClientRecipe getRecipe(int id) {
        return ClientRecipe.fromRecipe(this.session.get(Recipe.class, id));
    }

    public List<ClientRecipe> getAllRecipes(){
        List<Recipe> recipes = session.createCriteria(Recipe.class).list();
        List<ClientRecipe> clientRecipes = new ArrayList<>();
        recipes.forEach(recipe -> {
            clientRecipes.add(ClientRecipe.fromRecipe(recipe));
        });
        return clientRecipes;
    }
    
    public void deleteRecipe(int id){
    	Recipe r = (Recipe)this.session.load(Recipe.class, id);
    	session.delete(r);
    	session.flush();
    }
    
    public void updateRecipe(Recipe recipe){
    	int recipeId = recipe.getRecipeId();
    	deleteRecipe(recipeId);
    	saveRecipe(recipe);
    }
}
