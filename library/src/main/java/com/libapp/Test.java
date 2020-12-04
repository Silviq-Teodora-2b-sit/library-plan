package com.libapp;

import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.libapp.service.HibernateUtil;
import com.libapp.service.Service;
import com.libapp.service.ServiceImpl;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class Test {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
   
		
		/*final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
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
	            
		*/
	/*	UserDAO u=new UserDAO();
		u.openCurrentSession();
		User user= u.get(1);
		u.closeCurrentSession();
	System.out.println(user.toString());*/
		/*
			 
		 List<User> ls =svs.query(null);
		  if (ls != null) {
		   for (User c : ls) {
		    System.out.println(c.toString());
		   }
		
	    }
		  Service<User> svs = new ServiceImpl<User>(
			    User.class, HibernateUtil.getSessionFactory());
		  Map<Integer, Object> data = new HashMap<Integer, Object>();
	         data.put(0, "admin@abv.bg");
	         data.put(1, "admin");
	         
	         User user=svs.namedQuery("User.byEmailAndPass", data);
	         System.out.println(user.toString());

		*/
		/*
		Service<User> svs = new ServiceImpl<User>(
			    User.class, HibernateUtil.getSessionFactory());
		Map<Integer, Object> data = new HashMap<Integer, Object>();
        data.put(0, "admn");
        data.put(1, "admin@abv.bg");
       
        
       User user= svs.namedQuery("User.Registration", data); System.out.println(user.toString());
        
      
		*/
	/*	Service<User> userService = new ServiceImpl<User>(User.class, HibernateUtil.getSessionFactory());
		Service<Role> roleSer = new ServiceImpl<Role>(Role.class, HibernateUtil.getSessionFactory());
		Map<Integer, Object> data = new HashMap<Integer, Object>();
        data.put(0, "rede");User user=new User();
        Role r=roleSer.namedQuery("Role.Check", data);
        if(r!=null) {
	    r=	roleSer.namedQuery("Role.Check", data);
		
		user.setUserName("ss");
		user.setUserEmail("sisi@abv.bg");
		user.setUserPhone("0898464603");
		user.setUserPass("1234567");
		user.setUserRole(r);
		userService.save(user);
		}
        
		else {
			r=new Role("reader");
			user.setUserName("sissss");
			user.setUserEmail("sisi@abv.bg");
			user.setUserPhone("0898464603");
			user.setUserPass("1234567");
			user.setUserRole(r);
			userService.save(user);
		}*/
	}
	}
		
	


