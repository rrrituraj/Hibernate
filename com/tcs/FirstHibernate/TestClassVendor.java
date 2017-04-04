package com.tcs.FirstHibernate;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestClassVendor {

	public static void main(String[] args) {
		
		
		try {
			Configuration cfg = new Configuration();
			cfg.configure("resources/Vendor.cfg.xml");
			 
			SessionFactory factory = cfg.buildSessionFactory();
			Session session = factory.openSession();	 
			Transaction tx = session.beginTransaction();
			
			//Parent Obect
			Vendor v=new Vendor();
			v.setVendorID(101);
			v.setVendorName("Rituraj");
			
			//Child Object
			Customer cs=new Customer();
			cs.setCustId(1);
			cs.setCustName("shakti");
			cs.setVendorId(101);
			
			//2nd child object
			Customer cs1=new Customer();
			cs1.setCustId(2);
			cs1.setCustName("khujju");
			cs1.setVendorId(101);
			
			//creating set
			Set<Customer> s=new HashSet<>();
			s.add(cs1);
			s.add(cs);
			
			v.setChildren(s);
			 
			session.save(v);
			 
			tx.commit();
			session.close();
			System.out.println("One To Many is Done..!!");
			factory.close();
		} catch (HibernateException e) {
			System.out.println(e);
		}

	}

}
