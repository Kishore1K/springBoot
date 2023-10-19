package com.sprinng;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Hello World!" );
        Configuration cfgConfiguration = new Configuration();
        cfgConfiguration.configure("hibernate.cfg.xml");
        
        SessionFactory factory = cfgConfiguration.buildSessionFactory();
//    or this     SessionFactory  factory =  new Configuration().configure().buildSessionFactory();
        
        
        
        System.out.println(factory);
        
        
        	Student student = new Student();
        	student.setCity("KGF");
        	student.setId(4);
        	student.setName("abi");
        	
        	System.out.println(student);

//			Image
		FileInputStream fio = new FileInputStream("D:\\JAVA\\JAVAEE\\springBoot\\Hibernate\\src\\main\\resources\\resume_preview.png");
		byte[] data = new byte[fio.available()];
		fio.read(data);

//			Address Table
		Address address = new Address();
		address.setCity("KGF");
		address.setStreet("1st cross");
		address.setOpen(true);
		address.setAddedDate(new Date());
		address.setX(12.455);
		address.setImage(data);
		System.out.println("address = " + address);
        	
        	Session session = factory.openSession();
//        	session.beginTransaction();
        	Transaction tx = session.beginTransaction();
        	session.save(student);
			session.save(address);
//        	session.getTransaction().commit();
        	tx.commit();
        	
        	session.close();
    }
}
