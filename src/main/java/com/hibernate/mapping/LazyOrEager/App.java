package com.hibernate.mapping.LazyOrEager;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.hibernate.mapping.oneToOneEx.Answer;

public class App {

	public static void main(String[] args) {

		// creating question
		QuestionLOrE q1 = new QuestionLOrE();
		q1.setQuestionsId(1212);
		q1.setQuestion("What is java");

		// creating answer
		AnswerLOrE answer = new AnswerLOrE();
		answer.setAnswerId(301);
		answer.setAnswer("Java is a programming language");
		answer.setQuestion(q1);

		AnswerLOrE answer1 = new AnswerLOrE();
		answer1.setAnswerId(302);
		answer1.setAnswer("With the help of java we can create software");
		answer1.setQuestion(q1);

		AnswerLOrE answer2 = new AnswerLOrE();
		answer2.setAnswerId(303);
		answer2.setAnswer("Java is a programming language");
		answer2.setQuestion(q1);

		// add the List of answer
		List<AnswerLOrE> list = new ArrayList<AnswerLOrE>();
		list.add(answer);
		list.add(answer1);
		list.add(answer2);

		// set answer in question one questions have many answers
		q1.setAnswers(list);

		Configuration config = new Configuration().configure().addAnnotatedClass(QuestionLOrE.class)
				.addAnnotatedClass(AnswerLOrE.class);
		ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(config.getProperties())
				.buildServiceRegistry();
		SessionFactory sf = config.buildSessionFactory(registry);
		Session session = sf.openSession();
		session.beginTransaction();

		QuestionLOrE q = (QuestionLOrE) session.get(QuestionLOrE.class, 1212);
		System.out.println(q.getQuestionsId());
		System.out.println(q.getQuestion());
		System.out.println(q.getAnswers());

		session.getTransaction().commit();

		session.close();

	}
}
