/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WS.DAOs;

import com.WS.SessionFactoryFactory;
import com.WS.Beans.Ingredient;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Eric
 */

public class IngredientDAO {

    private final SessionFactory factory = SessionFactoryFactory.getSessionFactory();
    private final Session session;

    public IngredientDAO() {
        session = factory.openSession();
        session.beginTransaction();
    }

    public Ingredient getIngredientById(int i) {
        return session.get(Ingredient.class, i);
    }

    public Ingredient getIngredientByName(String name) {
        Criteria c1 = session.createCriteria(Ingredient.class);
        c1.add(Restrictions.like("name", name, MatchMode.EXACT));
        return (Ingredient) c1.uniqueResult();
    }

    public void saveIngredient(Ingredient ingredient) {
        session.persist(ingredient);
        session.flush();
        session.getTransaction().commit();
    }
}
