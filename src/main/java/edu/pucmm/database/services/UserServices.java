package edu.pucmm.database.services;

import edu.pucmm.database.entities.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class UserServices {
    private static UserServices instancia;
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private Users usersActivo;

    public void setActiveUser(Users users) {
        usersActivo = users;
    }

    public Users getUsuarioActivo() {
        return usersActivo;
    }

    private UserServices() {}

    public static UserServices getInstance() {
        if (instancia == null) {
            instancia = new UserServices();
        }
        return instancia;
    }

    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public Users saveUser(Users users) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.saveOrUpdate(users);

            transaction.commit();
            return users;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    public boolean userMatch(String username, String password) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Query<Users> query = session.createQuery("FROM Users WHERE username = :username AND password = :password", Users.class);
            query.setParameter("username", username);
            query.setParameter("password", password);
            Users users = query.uniqueResult();

            if (users == null) {
                return false;
            }
            setActiveUser(users);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
