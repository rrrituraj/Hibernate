package com.tcs.FirstHibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

@SuppressWarnings("unused")
public class TestRelianceNSE {

	public static void main(String[] args) {
		new RelianceNSE();
		try{
			Configuration cfg = new Configuration();
			cfg.configure("resources/reliancense.cfg.xml");
			SessionFactory sf = cfg.buildSessionFactory();
			Session session = sf.openSession();
			Transaction t = session.beginTransaction();
			
			//Using HQL Query
			/*String hql="select OPENING_DATE, OPEN from RelianceNSE";
			Query q=session.createQuery(hql);
			List<Object[]> l=q.list();
			//System.out.println(l);
			for(Object[] s:l){
				System.out.println(s[0]+"   "+s[1]);
			}*/
			
			/*//using criteria
			Criteria cr=session.createCriteria(RelianceNSE.class);
			List<? extends RelianceNSE> l=cr.list();
			for(RelianceNSE e:l){
				System.out.println(e.getOPENING_DATE());
			}*/
			
				
			
			t.commit();
			sf.close();
			session.close();
			System.out.println("end");
			
		}catch(HibernateException e){
			System.out.println(e);
		}
		
	}

}
