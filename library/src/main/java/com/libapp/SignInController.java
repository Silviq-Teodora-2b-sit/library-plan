package com.libapp;

//import java.awt.event.ActionEvent;
import javafx.event.ActionEvent;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;



public class SignInController {

    @FXML
    private TextField tf_email_in;

    @FXML
    private PasswordField tf_pass_in;

    @FXML
    private Button btn_signIN;

    @FXML
    void onSignINClick(ActionEvent event) {

    	/*final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
	              .configure() // configures settings from hibernate.cfg.xml
	               .build();
	        try {
	            SessionFactory factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
	            Session session = factory.openSession();  
	           
	      User user=null;
	            String emilString=tf_email_in.getText();
	             String passString=tf_pass_in.getText();
	            Query query=session.createQuery("SELECT ur FROM User ur WHERE ur.userEmail=:emilString and ur.userPass=:passString");
	            		query.setString("userEmail", emilString);
	            		query.setString("userPass", passString);
	            user=(User)query.uniqueResult();
	            
	            if (user!=null) {
					System.out.println("Yes!");
				}
	            else System.out.println("No!");
	           
	        } catch (Exception ex) {
	           StandardServiceRegistryBuilder.destroy(registry);
	       }*/
    	
    	SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
    	Session session=sessionFactory.openSession();
    	session.beginTransaction();
    	  String email=tf_email_in.getText();
          String pass=tf_pass_in.getText();
    	Query query=session.getNamedQuery("User.byEmailAndPass");
    	query.setParameter(0, email);
    	query.setParameter(1, pass);
    	//query.setParameter("userPass", pass);
    	
    	User user=(User)query.uniqueResult();
    	/*
    	List<User> users =(List<User>)query.list();*/
    	session.getTransaction().commit();
    	session.close();
    	if(user!=null)
    	{
    		System.out.println("Yes!"+user.toString());
    	}
    	else System.out.println("NO!");
    	/*for(User user: users)
    		System.out.println(user.getUserName());*/
    }

}