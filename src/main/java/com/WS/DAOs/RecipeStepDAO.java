package com.WS.DAOs;

import com.WS.SessionFactoryFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class RecipeStepDAO {

    private final SessionFactory factory = SessionFactoryFactory.getSessionFactory();
    private final Session session;
	
    public RecipeStepDAO() {
        session = factory.openSession();
        session.beginTransaction();
    }
    
    
    
}
