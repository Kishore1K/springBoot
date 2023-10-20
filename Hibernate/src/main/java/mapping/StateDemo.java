package mapping;


import com.sprinng.Certificate;
import com.sprinng.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StateDemo {

  /*  Hibernate States:
    1. Transient
    2.Persistent
    3. Detached
    4. Removed
    */

    public static void main(String[] args) {
        System.out.println("Example of Hibernate State Object");

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        Student student = new Student();
        student.setId(1);
        student.setName("Manju");
        student.setCity("KGF");
        student.setCertificate(new Certificate("C++ ", "14Hrs"));
//     the above is    Transient state
//        --------------------------------------------------------------------------------
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(student);
//        Student : Persistent state - session, DB
//        -----------------------------------------------------------------------------------
        student.setName("Ankush");
        tx.commit();
        session.close();
//        student : Detached state  - DB






        factory.close();

    }
}
