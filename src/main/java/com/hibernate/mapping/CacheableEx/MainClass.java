package com.hibernate.mapping.CacheableEx;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class MainClass {

	public static void main(String[] args) {
		EmployeeCache a = null;
		Configuration con = new Configuration().configure().addAnnotatedClass(EmployeeCache.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		EmployeeCache emp = new EmployeeCache();
		emp.setId(113);
		emp.setName("Ramu");
		emp.setSalary(10000);

		Session session1 = sf.openSession();
		Transaction txn = session1.beginTransaction();
		session1.save(emp);
		a = (EmployeeCache)session1.get(EmployeeCache.class, 102);
		System.out.println(a);
		//within session if we want to print same date then it will provide data fro cache
		a = (EmployeeCache)session1.get(EmployeeCache.class, 102);
		System.out.println(a);
		a = (EmployeeCache)session1.get(EmployeeCache.class, 103);
		System.out.println(a);

		session1.getTransaction().commit();
        session1.close();
        
        Session session2 = sf.openSession();
		Transaction txn1 = session2.beginTransaction();
		a = (EmployeeCache)session2.get(EmployeeCache.class, 102);
		System.out.println(a);
		System.out.println(a);
		
		session2.getTransaction().commit();
        session2.close();
	}

}
