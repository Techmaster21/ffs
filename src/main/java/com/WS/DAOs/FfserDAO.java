/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WS.DAOs;

import com.WS.Beans.Ffser;
import com.WS.Beans.Recipe;
import com.WS.ClientBeans.ClientFfser;
import com.WS.ClientBeans.ClientRecipe;
import com.WS.SessionFactoryFactory;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Eric
 */
public class FfserDAO {

    private final SessionFactory factory = SessionFactoryFactory.getSessionFactory();
    private final Session session;

    public FfserDAO() {
        session = factory.openSession();
        session.beginTransaction();
    }

    public Ffser getFfser(int id) {
        return this.session.get(Ffser.class, id);
    }
    
//    public Set<Recipe> getAllRecipesByFfser(int id) {
//        return session.get(Ffser.class, id).getRecipes();
//    }
}
