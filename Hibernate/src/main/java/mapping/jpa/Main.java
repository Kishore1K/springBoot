package mapping.jpa;
import mapping.jpa.entites.Laptop;
import mapping.jpa.entites.Students;
import mapping.jpa.repo.StudentsRepo;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

public class Main {

    public static void main(String[] args) {
        System.out.println("Main.main");


        Session session = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();

        Students student = new Students();
        student.setId(3);
        student.setName("Kishore 3");
        student.setAbout("nothing to say");

        Laptop laptop = new Laptop(103, "Pavilion 15", "HP", student);
        student.setLaptop(laptop);

        Transaction tx = session.beginTransaction();
//        session.save(student);
        tx.commit();

        System.out.println("session = " + session.get(Students.class, 1).getName());
        session.close();

//        one2Many
//        Many2Many



    }
}
