package mapping.jpa;
import mapping.jpa.entites.Laptop;
import mapping.jpa.entites.Students;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main.main");

        Session session = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();

        Students student = new Students();
        student.setId(1);
        student.setName("Kishore");
        student.setAbout("nothing to say");

        Laptop laptop = new Laptop(101, "Pavilion 15", "HP", student);
        student.setLaptop(laptop);


        Transaction tx = session.beginTransaction();
        session.save(student);
        session.save(laptop);
        tx.commit();
        session.close();

    }
}
