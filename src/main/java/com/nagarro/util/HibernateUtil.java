package com.nagarro.util;


import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nagarro.model.FlightData;
import com.nagarro.model.UserData;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	// Create the SessionFactory from hibernate.cfg.xml
	static {
		try {
			System.out.println("before cfg");
			sessionFactory = new Configuration().configure()
					.buildSessionFactory();
			System.out.println("created session factory");
		} catch (HibernateException cause) {
			System.out.println("Error Creating Session Factory");
			System.out.println(cause.getMessage());
			cause.printStackTrace();
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
