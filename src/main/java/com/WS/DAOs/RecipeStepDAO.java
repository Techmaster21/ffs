package com.WS.DAOs;

import com.WS.SessionFactoryFactory;
import com.WS.Beans.Ingredient;
import com.WS.Beans.RecipeStep;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class RecipeStepDAO {

    private final SessionFactory factory = SessionFactoryFactory.getSessionFactory();
    private final Session session;
	
    public RecipeStepDAO() {
        session = factory.openSession();
        session.beginTransaction();
    }
    
    public RecipeStep getRecipeStepById(int i) {
        return session.get(RecipeStep.class, i);
    }
    
    public void saveRecipeStep(RecipeStep recipeStep) {
        session.persist(recipeStep);
        session.flush();
        session.getTransaction().commit();
    }
    
    public void deleteRecipeStep(int id){
    	RecipeStep rs = (RecipeStep)this.session.load(RecipeStep.class, id);
    	session.delete(rs);
    	session.flush();
    }
    
    public void updateRecipeStep(RecipeStep recipeStep){
    	int recipeStepId = recipeStep.getStepId();
    	deleteRecipeStep(recipeStepId);
    	saveRecipeStep(recipeStep);
    }
    
}