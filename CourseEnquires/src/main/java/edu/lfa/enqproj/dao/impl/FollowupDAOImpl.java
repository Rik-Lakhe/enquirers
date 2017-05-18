/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.lfa.enqproj.dao.impl;

import edu.lfa.enqproj.dao.FollowupDAO;
import edu.lfa.enqproj.entity.Followup;
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
@Repository(value = "followupDAO")
public class FollowupDAOImpl implements FollowupDAO{
    
    @Autowired
    private SessionFactory sessionFactory;
    private Transaction trans;
    private Session session;
    
    @Override
    public int insert(Followup t) {
        session = sessionFactory.openSession();
        trans = session.beginTransaction();
        int result = (int) session.save(t);
        trans.commit();
        session.close();
        return result;
    }

    @Override
    public void update(Followup t) {
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
        Followup account = (Followup) session.get(Followup.class, id);
        if (account != null) {
            session.delete(account);
            success = true;
        }
        trans.commit();
        session.close();
        return success;
    }

    @Override
    public Followup getById(int id) {
        session = sessionFactory.openSession();
        Followup followup = (Followup) session.get(Followup.class, id);
        session.close();
        return followup;
    }

    @Override
    public List<Followup> getAll() {
        List<Followup> followup = null;
        session = sessionFactory.openSession();
        followup = session.createQuery("SELECT a FROM Followup a").list();
        session.close();
        return followup;
    }
    
}
