package com.tcs.FirstHibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class TestClassMovieTicketHQL {

	@SuppressWarnings({ "deprecation", "rawtypes", "unchecked" })
	public static void main(String[] args) {

		try {
			Configuration cfg = new Configuration();
			cfg.configure("resources/MovieBook.cfg.xml");
			SessionFactory sf = cfg.buildSessionFactory();
			Session session = sf.openSession();
			Transaction t = session.beginTransaction();

			String hql = "from MovieTicket where id='RITURAJ_1485524351435_2017'";
			String hql2 = "select id,Mname, seatno from MovieTicket";
			String hql1 = "select Mname from MovieTicket";
			String hql3 = "select max(seatno) from MovieTicket";
			
			Query q = session.createQuery(hql);
			Query q1 = session.createQuery(hql1);
			Query q2 = session.createQuery(hql2);
			Query q3 = session.createQuery(hql3);
			
			Object o = q.uniqueResult();
			List<String> l1 = q1.list();
			List<Object> l2 = q2.list();
			int max=(Integer)q3.uniqueResult();
			
			MovieTicket mv = (MovieTicket) o;
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nGot from  database \n\n");
			System.out.println(mv.getId() + "   " + mv.getMname() + "   " + mv.getSeatno() + "   " + mv.getShowtime());
			
			for (String name : l1) {
				System.out.println(name);

			}
			
			for(Object o2:l2){
				Object r[]=(Object[])o2;
				System.out.println(r[0]+"   "+r[1]+"   "+r[2]);
			}
			
			System.out.println("max seat no is "+max);
			t.commit();
			session.close();
			sf.close();

		} catch (HibernateException e) {
			System.out.println(e);
		}

	}

}
