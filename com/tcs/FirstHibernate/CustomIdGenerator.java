package com.tcs.FirstHibernate;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomIdGenerator implements IdentifierGenerator{

	@Override
	public Serializable generate(SharedSessionContractImplementor s, Object arg1) throws HibernateException {
		Date date = new Date();
        
        Calendar calendar = Calendar.getInstance();
        return "RITURAJ_" + date.getTime() + "_" + calendar.get(Calendar.YEAR);
	}
	

}
