/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.lfa.enqproj.dao.impl;

import edu.lfa.enqproj.dao.FacultyDAO;
import edu.lfa.enqproj.entity.Faculty;
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
@Repository(value = "facultyDAO")
public class FacultyDAOImpl implements FacultyDAO{
    
    @Autowired
    private SessionFactory sessionFactory;
    private Transaction trans;
    private Session session;
    
    @Override
    public int insert(Faculty t) {
        session = sessionFactory.openSession();
        trans = session.beginTransaction();
        int result = (int) session.save(t);
        trans.commit();
        session.close();
        return result;
    }

    @Override
    public void update(Faculty t) {
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
        Faculty account = (Faculty) session.get(Faculty.class, id);
        if (account != null) {
            session.delete(account);
            success = true;
        }
        trans.commit();
        session.close();
        return success;
    }

    @Override
    public Faculty getById(int id) {
        session = sessionFactory.openSession();
        Faculty faculty = (Faculty) session.get(Faculty.class, id);
        session.close();
        return faculty;
    }

    @Override
    public List<Faculty> getAll() {
        List<Faculty> faculty = null;
        session = sessionFactory.openSession();
        faculty = session.createQuery("SELECT a FROM Faculty a").list();
        session.close();
        return faculty;
    }
    
}
