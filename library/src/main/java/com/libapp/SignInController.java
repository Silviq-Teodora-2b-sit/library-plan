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

    	final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
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
	       }
    }

}