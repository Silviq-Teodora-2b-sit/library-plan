package com.libapp.service;


import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HibernateUtil {
	 private static final SessionFactory SessionFactory;
	 private static final StandardServiceRegistry serviceRegistry;
	 
	 static {
	        try {
	        	serviceRegistry = new StandardServiceRegistryBuilder()
		                .configure() // configures settings from hibernate.cfg.xml
		                .build();
	            SessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
	        } catch (Throwable ex) {
	            throw new ExceptionInInitializerError(ex);
	        }
	    }
	    
	    public static SessionFactory getSessionFactory() {
	     return SessionFactory;
	    }
	    
	    public static Session getSession() throws HibernateException {
	        return SessionFactory.openSession();
	    }
}
