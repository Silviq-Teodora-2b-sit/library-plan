package com.libapp;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

import java.util.HashMap;
import java.util.Map;

import com.libapp.service.HibernateUtil;
import com.libapp.service.Service;
import com.libapp.service.ServiceImpl;

import javafx.event.ActionEvent;

public class SingUpController {

    @FXML
    private TextField tf_name;

    @FXML
    private TextField tf_email_up;

    @FXML
    private TextField tf_phone;

    @FXML
    private PasswordField pf_pass_up;

    @FXML
    void SingUp(ActionEvent event) {
    	Service<User> userService = new ServiceImpl<User>(User.class, HibernateUtil.getSessionFactory());
    	String name=tf_name.getText();
    	 String email=tf_email_up.getText();
    	 String pass=pf_pass_up.getText();
    	 String phone=tf_phone.getText();
		if(name.length() <6 || email.isEmpty() ||
   			 phone.length()<10 || pass.length()<6)
        {
        	Alert alert=new Alert(AlertType.ERROR);
        	alert.setHeaderText(null);
        	alert.setContentText("Fill all required fields!");
        	alert.showAndWait();
        }
   	 else {
				Role r=new Role();
				User user=new User();
				user.setUserName(name);
				user.setUserEmail(email);
				user.setUserPhone(phone);
				user.setUserPass(pass);
				r.setRoleName(App.getControllerRole());
				user.setUserRole(r);
				
				 
				 Map<Integer, Object> data = new HashMap<Integer, Object>();
		         data.put(0, name);
		         data.put(1, email);
		         
		        User user1= userService.namedQuery("User.Registration", data);
		       
		        if(user1==null)
		        {
		        	userService.save(user);
		        	Alert alert=new Alert(AlertType.INFORMATION);
		        	alert.setHeaderText(null);
		        	alert.setContentText("Success!");
		        	alert.showAndWait();
		        }
		        else {
		        	Alert alert=new Alert(AlertType.ERROR);
		        	alert.setHeaderText(null);
		        	alert.setContentText("This User already exists!");
		        	alert.showAndWait();
		        }
		         
			}
		}
    }

