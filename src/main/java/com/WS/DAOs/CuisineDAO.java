/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WS.DAOs;

import com.WS.Beans.Cuisine;
import com.WS.SessionFactoryFactory;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Eric
 */
public class CuisineDAO {
    
    private final SessionFactory factory = SessionFactoryFactory.getSessionFactory();
    private final Session session;

    public CuisineDAO() {
        session = factory.openSession();
        session.beginTransaction();
    }
    
    public List<Cuisine> getAllCuisines(){
        return session.createCriteria(Cuisine.class).list();
    }
}
