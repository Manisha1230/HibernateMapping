package com.hibernate.mapping.oneToOneEx;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
public class App {
	public static void main(String[] args) {

		// creating question
		Question q1 = new Question();
		q1.setQuestionId(1213);
		q1.setQuestion("What is java");

		// creating answer
		Answer answer = new Answer();
		answer.setAnswerId(343);
		answer.setAnswer("Java is a programming language");
		answer.setQuestion(q1);
		q1.setAnswer(answer);

		// create question
		Question q2 = new Question();
		q2.setQuestionId(242);
		q2.setQuestion("What is collection framework");

		// creating answer
		Answer answer1 = new Answer();
		answer1.setAnswerId(344);
		answer1.setAnswer("Api to work with objects in java");
		answer1.setQuestion(q2);
		q2.setAnswer(answer1);

		Configuration config = new Configuration().configure().addAnnotatedClass(Question.class)
				.addAnnotatedClass(Answer.class);
		ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(config.getProperties())
				.buildServiceRegistry();
		SessionFactory sf = config.buildSessionFactory(registry);
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(q1);
		session.save(answer);
		session.save(answer1);

		session.save(q2);

		session.getTransaction().commit();

		// fetching the data question with answer
		Question newq = (Question) session.get(Question.class, 1212);
		System.out.println(newq.getQuestion());
		System.out.println(newq.getAnswer().getAnswer());

		// fetching the data answer with question
		Answer newq1 = (Answer) session.get(Answer.class, 343);
		System.out.println(newq1.getAnswer());
		System.out.println(newq.getQuestion());

		session.close();
}
}
