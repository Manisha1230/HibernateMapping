package com.hibernate.mapping.o2m;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App {
	public static void main(String[] args) {
		Student student = new Student();
		student.setRollno(4);
		student.setName("nisha");
		student.setMarks(50);
		
		Laptop laptop = new Laptop();
		laptop.setLaptopid(110);
		laptop.setLaptopname("Dell");
		laptop.setStud(student);

		Laptop laptop1 = new Laptop();
		laptop1.setLaptopid(105);
		laptop1.setLaptopname("Acer");
		laptop1.setStud(student);

		
		

		// OneToMany

		Configuration config = new Configuration().configure().addAnnotatedClass(Student.class)
				.addAnnotatedClass(Laptop.class);
		ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(config.getProperties())
				.buildServiceRegistry();
		SessionFactory sf = config.buildSessionFactory(registry);
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(laptop);
		session.save(laptop1);
		session.save(student);

		session.getTransaction().commit();
		session.close();

	}
}
