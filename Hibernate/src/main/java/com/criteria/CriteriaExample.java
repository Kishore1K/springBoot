package com.criteria;

import com.sprinng.Student;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class CriteriaExample {
    public static void main(String[] args) {
        SessionFactory factory= new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        Criteria c = session.createCriteria(Student.class);
//        c.add(Restrictions.eq("city", "KGF"));
        c.add(Restrictions.gt("id", 25));
        System.out.println("Students = " + c.list());


        session.close();
        factory.close();
    }
}
