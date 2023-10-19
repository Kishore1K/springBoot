package com.sprinng;

import org.hibernate.SessionFactory;
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
    }
}
