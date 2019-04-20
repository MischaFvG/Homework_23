package com.cat.dao;

import com.cat.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class MariaDBDao {
    private SessionFactory sessionFactory;

    public MariaDBDao() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public List<Student> getAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Student", Student.class).list();
        }
    }

    public void pushAll(List<Student> studentList) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            for (int i = 0; i < studentList.size(); i++) {
                session.update(studentList.get(i));
            }
            transaction.commit();
        }
    }

    public void dropTable() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.createSQLQuery("DROP TABLE students").executeUpdate();
            transaction.commit();
        }
    }
}
