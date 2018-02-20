/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WS.DAOs;

import com.WS.Beans.Recipe;
import com.WS.Beans.Unit;
import com.WS.ClientBeans.ClientRecipe;
import com.WS.ClientBeans.ClientUnit;
import com.WS.SessionFactoryFactory;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Eric
 */
public class UnitDAO {

    private final SessionFactory factory = SessionFactoryFactory.getSessionFactory();
    private final Session session;

    public UnitDAO() {
        session = factory.openSession();
        session.beginTransaction();
    }

    public List<ClientUnit> getAllUnits() {
        return session.createCriteria(Unit.class).list();
    }
    
    public void saveUnit(Unit unit){
        session.persist(unit);
        session.flush();
        session.getTransaction().commit();
    }
}