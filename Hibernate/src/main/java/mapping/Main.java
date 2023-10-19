package mapping;

import mapping.One2One.Answer;
import mapping.One2One.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

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
        Answer answer1 = new Answer(102, "Robust",question);
        Answer answer2 = new Answer(103, "platform independent",question);

        question.setAnswers(Arrays.asList(answer, answer1, answer2));









/*
        session.save(question);
        session.save(answer);
        session.save(answer1);
        session.save(answer2);
*/


        tx.commit();
//        Fetching data
        System.out.println("Question = " + session.get(Question.class, 1));
        System.out.println("Answer = " + session.get(Answer.class, 101));
        session.close();

        factory.close();
    }
}
