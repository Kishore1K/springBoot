package com.cacheing;

import com.sprinng.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SecondLevel {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Session session = factory.openSession();

        Student student =  session.get(Student.class, 4);
        System.out.println("student = " + student);

        session.close();


        Session session1 = factory.openSession();

        Student student1 =  session1.get(Student.class, 4);
        System.out.println("student = " + student1);

        session1.close();
        factory.close();
    }
}
