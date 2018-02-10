/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WS.DAOs;

import com.WS.Beans.Recipe;
import com.WS.SessionFactoryFactory;
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
    
    public void saveRecipe(Recipe recipe){
        this.session.persist(recipe);
        this.session.flush();
        this.session.getTransaction().commit();
    }
    
    
    
}
