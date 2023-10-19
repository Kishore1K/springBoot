package com.sprinng;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class FetchDemo {

    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        Session session = factory.openSession();

//        get
        Student student = (Student) session.get(Student.class, 4);
        System.out.println("student = " + student);
        
        Address address = (Address) session.load(Address.class, 1);
        System.out.println("address = " + address);

        Student student1 = (Student) session.get(Student.class, 4);
        System.out.println("student1 = " + student1);
        session.close();
        factory.close();

    }
}
