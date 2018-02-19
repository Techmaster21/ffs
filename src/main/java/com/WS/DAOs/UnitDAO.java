/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WS.DAOs;

import com.WS.Beans.Unit;
import com.WS.SessionFactoryFactory;
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

    public List<Unit> getAllFoods() {
        return session.createCriteria(Unit.class).list();
    }
}
