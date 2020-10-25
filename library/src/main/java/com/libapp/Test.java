package com.libapp;

import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
   
		
		 final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
	                .configure() // configures settings from hibernate.cfg.xml
	                .build();
	        try {
	            SessionFactory factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
	            Session session = factory.openSession();  
	          
	            Transaction transaction = session.beginTransaction();
	             
	             Role role=new Role("admin");
	             User user=new User("admin","admin@abv.bg","0898746238","admin",role);
	             
	            session.save(user);
	             
	            transaction.commit();
	             
	            session.close();
	            factory.close();
	            
	        } catch (Exception ex) {
	            StandardServiceRegistryBuilder.destroy(registry);
	        }
	    }
		
	}


