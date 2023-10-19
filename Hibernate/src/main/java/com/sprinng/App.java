package com.sprinng;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Configuration cfgConfiguration = new Configuration();
        cfgConfiguration.configure("hibernate.cfg.xml");
        
        SessionFactory factory = cfgConfiguration.buildSessionFactory();
//    or this     SessionFactory  factory =  new Configuration().configure().buildSessionFactory();
        
        
        
        System.out.println(factory);
        
        
        	Student student = new Student();
        	student.setCity("ch");
        	student.setId(2);
        	student.setName("manju");
        	
        	System.out.println(student);
        	
        	Session session = factory.openSession();
//        	session.beginTransaction();
        	Transaction tx = session.beginTransaction();
        	session.save(student);
//        	session.getTransaction().commit();
        	tx.commit();
        	
        	session.close();
    }
}
