package com.hql;

import com.sprinng.Certificate;
import com.sprinng.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Objects;

public class HQLPagination {
    public static void main(String[] args) {
        System.out.println("HQLPagination.main");


        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();
/*        Student student;
        for(int i=4; i<=30; i++){
            student =new Student(i, "Kishore"+i, "City"+i, new Certificate("course"+i, i+" Hrs"));
            session.save(student);
        }*/
        tx.commit();

        Query query= session.createQuery("from Student ");


//        implementing pagination using hibernate

        query.setFirstResult(0);
        query.setMaxResults(5);
        System.out.println("query.list() = " + query.list());















        session.close();
        factory.close();

    }
}
