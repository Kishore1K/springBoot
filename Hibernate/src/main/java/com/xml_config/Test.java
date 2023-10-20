package com.xml_config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {
        System.out.println("Test.main");
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();
        Person person = new Person();
        person.setId(124);
        person.setName("Kishore");
        person.setAddress("KGF");
        person.setPhone("123456789");
        session.save(person);
        tx.commit();
        session.close();
        factory.close();
    }
}
