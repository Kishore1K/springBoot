package com.sql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class NativeQuery {
    public static void main(String[] args) {
        System.out.println("NativeQuery.main");
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        tx.commit();

        String query = "select * from student";
////        System.out.println(session.createNativeQuery(query).list());
        Query q =  session.createNativeQuery(query);

        List<Object[]> list = q.list();
        for (Object[] student: list) {
            System.out.println(Arrays.toString(student));
            
        }
        session.close();

        factory.close();
    }
}
