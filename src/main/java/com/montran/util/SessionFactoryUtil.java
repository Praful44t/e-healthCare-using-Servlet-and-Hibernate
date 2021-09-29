package com.montran.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryUtil {

	static SessionFactory sf;

	public static SessionFactory StartSessionFactory() {
		if (sf == null)
			sf = new Configuration().configure().buildSessionFactory();
		return sf;
	}
	
}