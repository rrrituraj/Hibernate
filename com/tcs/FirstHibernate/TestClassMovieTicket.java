package com.tcs.FirstHibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestClassMovieTicket {

	public static void main(String[] args) {
		try {
			Configuration cfg = new Configuration();
			cfg.configure("resources/MovieBook.cfg.xml");
			SessionFactory sf = cfg.buildSessionFactory();
			Session session = sf.openSession();
			Transaction t = session.beginTransaction();

			MovieTicket mv = new MovieTicket();
			//mv.setId(2);
			mv.setMname("Kabil");
			mv.setSeatno(56);
			mv.setShowtime("10AM");

			String mt = (String) session.save(mv);
			t.commit();
			session.close();
			sf.close();
			System.out.println("inserted to database "+mt);
		} catch (HibernateException e) {
			System.out.println(e);
		}

	}

}
