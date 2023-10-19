package mapping;

import mapping.One2One.Answer;
import mapping.One2One.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory factory = configuration.buildSessionFactory();

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();



        Question question = new Question();
        question.setQuestion("Java is a ");


        Answer answer = new Answer();
        answer.setAnswerId(101);
        answer.setQuestion(question);
        answer.setAnswer("programing Language");
        question.setAnswer(answer);



        Question question1 = new Question();
        question1.setQuestion("bangalore is at ");

        Answer answer1 = new Answer();
        answer1.setAnswerId(102);
        answer1.setQuestion(question1);
        answer1.setAnswer("Karanataka");
        question1.setAnswer(answer1);




        Question question2 = new Question();
        question2.setQuestion("my name is");
        Answer answer2 = new Answer();
        answer2.setAnswerId(103);
        answer2.setQuestion(question2);
        answer2.setAnswer("Kishore");
        question2.setAnswer(answer2);





        session.save(question);
        session.save(question1);
        session.save(question2);
        session.save(answer);
        session.save(answer1);
        session.save(answer2);


        tx.commit();
//        Fetching data
        System.out.println("Question = " + session.get(Question.class, 1));
        System.out.println("Answer = " + session.get(Answer.class, 101));
        session.close();

        factory.close();
    }
}
