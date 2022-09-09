package com.hibernate.mapping.HqlExample;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.hibernate.mapping.LazyOrEager.AnswerLOrE;
import com.hibernate.mapping.LazyOrEager.QuestionLOrE;
import com.hibernate.mapping.ObjectsStates.StudentObjectsState;
import com.hibernate.mapping.OneTomanyeEx.AnswerM2O;
import com.hibernate.mapping.OneTomanyeEx.QuestionO2M;
import com.hibernate.mapping.oneToOneEx.Question;

public class HqlExample1 {

	public static void main(String[] args) {
		Configuration config = new Configuration().configure().addAnnotatedClass(StudentObjectsState.class)
				.addAnnotatedClass(QuestionO2M.class).addAnnotatedClass(AnswerM2O.class);
		ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(config.getProperties())
				.buildServiceRegistry();
		SessionFactory sf = config.buildSessionFactory(registry);
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		// String query = "from StudentObjectsState where city='Delhi'";
		String query = "from StudentObjectsState as session where session.city=:x and session.name=:n";// as session is
																										// called
																										// projection
		Query q = session.createQuery(query);
		// passing two parameter to fetching the data
		q.setParameter("x", "Delhi");
		q.setParameter("n", "nisha");

		// single-(Unique)
		// multiple-list
		// q.uniqueResult();fetching the unique value
		List<StudentObjectsState> list = q.list();
		for (StudentObjectsState student : list) {
			System.out.println(student.getName() + " : " + student.getCerti().getCoursename());
		}

		System.out.println("------------------------------------");

		// Delete query
		/*
		 * Query q2 = session.
		 * createQuery("delete from StudentObjectsState as session where session.city=:c"
		 * ); q2.setParameter("c", "Bihar"); int r = q2.executeUpdate();
		 * System.out.println(r);
		 */

		// Update query
		Query q2 = session
				.createQuery("update StudentObjectsState as session  set session.city=:c where session.name=:n");
		q2.setParameter("c", "Bangluru");
		q2.setParameter("n", "nisha");
		int r = q2.executeUpdate();
		System.out.println(r + "Object updated");

		// Execute join query
		Query q3 = session.createQuery("select q.question ,q.questionsId,a.answer from QuestionO2M as q INNER JOIN q.answers as a");
		List<Object[]> list3 = q3.list();
		for (Object[] arr : list3) {
			System.out.println(Arrays.toString(arr));
		}
		System.out.println();

		session.getTransaction().commit();

		session.close();
	}

}
