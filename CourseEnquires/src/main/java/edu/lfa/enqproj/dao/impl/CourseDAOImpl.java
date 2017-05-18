/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.lfa.enqproj.dao.impl;

import edu.lfa.enqproj.dao.CourseDAO;
import edu.lfa.enqproj.entity.Course;
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
@Repository(value = "courseDAO")
public class CourseDAOImpl implements CourseDAO{
    
    @Autowired
    private SessionFactory sessionFactory;
    private Transaction trans;
    private Session session;
    
    @Override
    public int insert(Course t) {
        session = sessionFactory.openSession();
        trans = session.beginTransaction();
        int result = (int) session.save(t);
        trans.commit();
        session.close();
        return result;
    }

    @Override
    public void update(Course t) {
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
        Course account = (Course) session.get(Course.class, id);
        if (account != null) {
            session.delete(account);
            success = true;
        }
        trans.commit();
        session.close();
        return success;
    }

    @Override
    public Course getById(int id) {
        session = sessionFactory.openSession();
        Course course = (Course) session.get(Course.class, id);
        session.close();
        return course;
    }

    @Override
    public List<Course> getAll() {
        List<Course> course = null;
        session = sessionFactory.openSession();
        course = session.createQuery("SELECT a FROM Course a").list();
        session.close();
        return course;
    }
    
}
