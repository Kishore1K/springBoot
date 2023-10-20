package mapping.cascade;

import mapping.One2One.Answer;
import mapping.One2One.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CascadeExample {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Question question = new Question();
        question.setQuestion("C# ");

        Answer a = new Answer(15, "Developed by Microsoft", question);
        Answer a1 = new Answer(16, "used to develop Desktop applications", question);
        Answer a2 = new Answer(17, ".NET is a FrameWork", question);
        question.setAnswers(List.of(a, a1, a2));
        Transaction tx = session.beginTransaction();
        session.save(question);
/*        session.save(a);
        session.save(a1);
        session.save(a2);*/
        tx.commit();

        session.close();
        factory.close();
    }
}
