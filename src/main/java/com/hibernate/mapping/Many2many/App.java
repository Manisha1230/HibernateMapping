package com.hibernate.mapping.Many2many;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App {
	public static void main(String[] args) {
		
		Employee e1 =new Employee();
		Employee e2 = new Employee();
		
		e1.setEmpid(10);
		e1.setName("Manisha");
		
		e2.setEmpid(20);
		e2.setName("Nisha");
		
		Project p1 = new Project();
		Project p2 = new Project();
		
		p1.setProjectid(1001);
		p1.setProjectName("java Project");
		
		p2.setProjectid(1002);
		p2.setProjectName("Python Project");
		
		//creating List to store employee
		List<Employee> listemp = new ArrayList<Employee>();
		listemp.add(e1);
		listemp.add(e2);
		//creating List to store project
	    List<Project> listpro = new ArrayList<Project>();
	    listpro.add(p1);
	    listpro.add(p2);
	    
	    //provide two projects to  employee
	    e1.setProject(listpro);
	    p2.setEmployee(listemp);
	    
	    
		

		Configuration config = new Configuration().configure().addAnnotatedClass(Project.class)
				.addAnnotatedClass(Employee.class);
		ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(config.getProperties())
				.buildServiceRegistry();
		SessionFactory sf = config.buildSessionFactory(registry);
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(e1);
		session.save(e2);
		session.save(p1);
		session.save(p2);

		session.getTransaction().commit();
		session.close();

	}
}
