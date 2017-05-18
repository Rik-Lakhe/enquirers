/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.lfa.enqproj.dao.impl;

import edu.lfa.enqproj.dao.EnquiresDAO;
import edu.lfa.enqproj.entity.Enquires;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author LAKHE
 */
@Repository(value = "enquiresDAO")
public class EnquiresDAOImpl implements EnquiresDAO{
    
    @Autowired
    private SessionFactory sessionFactory;
    private Transaction trans;
    private Session session;
    
    @Override
    public int insert(Enquires t) {
        session = sessionFactory.openSession();
        trans = session.beginTransaction();
        int result = (int) session.save(t);
        trans.commit();
        session.close();
        return result;
    }

    @Override
    public void update(Enquires t) {
        session = sessionFactory.openSession();
        trans = session.beginTransaction();
        session.saveOrUpdate(t);
        trans.commit();
        session.close();
    }

    @Override
    public boolean delete(int id) {
        boolean success = false;
        session = sessionFactory.openSession();
        trans = session.beginTransaction();
        Enquires account = (Enquires) session.get(Enquires.class, id);
        if (account != null) {
            session.delete(account);
            success = true;
        }
        trans.commit();
        session.close();
        return success;
    }

    @Override
    public Enquires getById(int id) {
        session = sessionFactory.openSession();
        Enquires enquires = (Enquires) session.get(Enquires.class, id);
        session.close();
        return enquires;
    }

    @Override
    public List<Enquires> getAll() {
        List<Enquires> enquires = null;
        session = sessionFactory.openSession();
        enquires = session.createQuery("SELECT a FROM Enquires a").list();
        session.close();
        return enquires;
    }
    
}
