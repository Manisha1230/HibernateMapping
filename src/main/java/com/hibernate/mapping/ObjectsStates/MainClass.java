package com.hibernate.mapping.ObjectsStates;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class MainClass {

	public static void main(String[] args) {
		Configuration con = new Configuration().configure().addAnnotatedClass(StudentObjectsState.class);
		ServiceRegistry srg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(srg);
		// creating object of certificate
		Certificate c = new Certificate();
		c.setCoursename("RDBMS");
		c.setDuration("3 Months");
		// creating student object
		StudentObjectsState student = new StudentObjectsState();

		student.setId(105);
		student.setName("Rahul");
		student.setCity("Lucknow");
		student.setCerti(c);
		//student : Transient

		Session session = sf.openSession();
		Transaction txn = session.beginTransaction();
		session.save(student);
		//Student : Persistent - associated with session,database
		//student.setName("Nisha");//here if we want to change data before close the session then it will change but after closing the session we can not change value

		txn.commit();
		session.close();
		//student : Detached state
		

	}

}
