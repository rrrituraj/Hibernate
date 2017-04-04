package com.tcs.FirstHibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestClassStudent {

	public TestClassStudent() {

	}

	public static void main(String[] args) {
		Student st = new Student();
		st.setId(11);
		st.setName("Rituraj Gupta");
		st.setEmail("guptamaharaj@gmail.com");
		st.setMarks(500);
		st.setRank(101);
		// student object is transient

		try {
			Configuration cfg = new Configuration();
			cfg.configure("resources/hibernate1.cfg.xml");
			SessionFactory sf = cfg.buildSessionFactory();
			Session s = sf.openSession();
			Transaction t=s.beginTransaction();
			//s.saveOrUpdate(st);
			// student object state is persistent
			
			//select operations
			Object o=s.load(Student.class, 500); // fire null pointer exception if id not found
			Student st1=(Student)o;
			System.out.println(st1.getId()+"  "+st1.getName()+"  "+st1.getEmail());
			
			t.commit();
			// student object will move to database
			s.close();
			sf.close();
			// student object will be delete from session(remove from persistent)
			// then gc() can collect student object
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}

	}

}