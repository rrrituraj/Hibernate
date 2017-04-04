package com.tcs.FirstHibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestClassEmplyee {

	public static void main(String[] args) {
		
		try {
			Configuration cfg = new Configuration();
			cfg.configure("resources/emplyee.cfg.xml");
			SessionFactory sf = cfg.buildSessionFactory();
			Session session = sf.openSession();
			Transaction t = session.beginTransaction();
			
			SEmplyee se=new SEmplyee();
			se.setId(3);
			se.setName("Rituraj");
			se.setEmail("raj@gmail.com");
			se.setSalary(500000);
			se.setTool("software");
			
			HEmplyee he=new HEmplyee();
			he.setId(30);
			he.setName("Sushil");
			he.setEmail("sushil@gmail.com");
			he.setSalary(600000);
			he.setTool("Hardware");
			
			session.save(se);
			session.save(he);
			
			t.commit();
			session.close();
			sf.close();
		} catch (HibernateException e) {
			System.out.println(e);
		}
		
	}

}
