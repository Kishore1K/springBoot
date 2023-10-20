package com.hql;

import com.sprinng.Student;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.awt.*;

public class HqlExample {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        String query1 = "from Student where city='KGF'";
        String query = "from Student where city=:x";

        transaction.commit();
        Query q = session.createQuery(query);
        q.setParameter("x", "KGF");
//        Single -Unique
//        multiple - list
//        q.uniqueResult();
        System.out.println("q.list() = " + q.list());
        session.close();
        factory.close();
    }
}
