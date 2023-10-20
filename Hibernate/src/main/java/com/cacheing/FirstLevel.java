package com.cacheing;

import com.sprinng.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FirstLevel {
    public static void main(String[] args) {
        System.out.println("FirstLevel.main");
        SessionFactory factory= new Configuration().configure().buildSessionFactory();

        Session session = factory.openSession();
//        by default enabled
        System.out.println(session.get(Student.class,3));
        System.out.println(session.get(Student.class, 3));
        System.out.println(session.contains(session.get(Student.class,3)));
        session.close();

        factory.close();
    }
}
