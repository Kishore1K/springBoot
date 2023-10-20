package com.hql;

import com.sprinng.Certificate;
import com.sprinng.Student;
import mapping.One2One.Answer;
import mapping.One2One.Question;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.awt.*;

public class HqlExample {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        String query1 = "from Student where city='KGF'";
        String query = "from Student where city=:x";

        Query q = session.createQuery(query);
        q.setParameter("x", "KGF");
//        Single -Unique
//        multiple - list
//        q.uniqueResult();
        System.out.println("q.list() = " + q.list());
//        ---------------------------------------------------------

        System.out.println("-----------------------------------------------------------");

 /*       Query q2= session.createQuery("delete  from Student where id=:id");
        q2.setParameter("id", 1);
        System.out.println(q2.executeUpdate());*/
//        --------------------------------------------------done with delete query


        System.out.println("-----------------------------------------------------------");
        Student student = new Student(2, "Manju", "CH Nagara", new Certificate("Java Core", "5 Months"));
        Student student1 = new Student(3, "Ankush", "Badharavathi", new Certificate("Java Core", "5 Months"));

/*        session.save(student);
        session.save(student1);*/
//-------------------------------------------------------------------------------------------- save students//
/*        Query q3 = session.createQuery("update  Student  set certificate.duration=:time where id=:id");
        q3.setParameter("time", "6 Months");
        q3.setParameter("id", 3);
        System.out.println(q3.executeUpdate());*/


//        -----------------------------------------------------------------------------------done with update--
        transaction.commit();
        Query query3 = session.createQuery(" select q.question , a.answer from Question q  inner  join  q.answers as a");

        System.out.println("query3.getResultList()) = " + query3.list());















        session.close();
        factory.close();
    }
}
