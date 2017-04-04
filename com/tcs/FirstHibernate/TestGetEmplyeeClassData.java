package com.tcs.FirstHibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestGetEmplyeeClassData {

	@SuppressWarnings({ "unchecked", "deprecation" })
	public static void main(String[] args) {
		try {
			Configuration cfg = new Configuration();
			cfg.configure("resources/emplyee.cfg.xml");
			SessionFactory sf = cfg.buildSessionFactory();
			Session session = sf.openSession();
			Transaction t = session.beginTransaction();
			
			Criteria cr=session.createCriteria(HEmplyee.class);
			List<Emplyee> l=cr.list();
			for(Emplyee e:l){
				System.out.println(e.getName()+"   "+e.getEmail());
			}
			
			t.commit();
			session.close();
			sf.close();
		} catch (HibernateException e) {
			System.out.println(e);
		}
	}

}
