package edu.pucmm.database.services;

import edu.pucmm.database.entities.Document;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class DocumentServices {
    private static DocumentServices instancia;
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private DocumentServices() {}

    public static DocumentServices getInstance() {
        if (instancia == null) {
            instancia = new DocumentServices();
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

    public Document saveRecord(Document record) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(record);
            transaction.commit();
            return record;
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

    public List<Document> getRecords() {
        Session session = null;
        List<Document> records = null;
        try {
            session = sessionFactory.openSession();
            Query<Document> query = session.createQuery("from Document", Document.class);
            records = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return records;
    }
}
