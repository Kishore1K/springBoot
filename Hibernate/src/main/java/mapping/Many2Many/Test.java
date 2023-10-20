package mapping.Many2Many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");

        SessionFactory factory = configuration.buildSessionFactory();

        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();

        Employee employee = new Employee();
        employee.setName("Kishore");

        Employee employee1 = new Employee();
        employee1.setName("Ankush");

        Employee employee2 = new Employee();
        employee2.setName("Manju");

        Project project = new Project();
        project.setPrjName("AI");

        Project project1 = new Project();
        project1.setPrjName("JAVA Prj");






        employee.setProjectList(Arrays.asList(project, project1));
        employee1.setProjectList(List.of(project, project1));
        employee2.setProjectList(List.of(project1));



        project.setEmployeeList(Arrays.asList(employee1, employee));
        project1.setEmployeeList(Arrays.asList(employee, employee2, employee1));





/*        session.save(employee);
        session.save(employee1);
        session.save(employee2);
        session.save(project);
        session.save(project1);*/

//        fetching

        System.out.println("Employee = " + session.get(Employee.class, 1));

        System.out.println("Project = " + session.load(Project.class, 2));









        tx.commit();
        session.close();

        factory.close();


    }
}
