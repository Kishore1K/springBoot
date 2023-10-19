package com.sprinng;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {
    public static void main(String[] args) {
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();


        Student student = new Student(2, "Kishore", "KGF",new Certificate("Hibernate", "12hrs") );
        System.out.println("student = " + student);
        Student student1 = new Student(3, "Akshay", "baleri",new Certificate("ASP.NET", "32hrs") );
        System.out.println("student1 = " + student1);

        session.save(student);
        session.save(student1);





        tx.commit();
        session.close();
        factory.close();


    }
}
