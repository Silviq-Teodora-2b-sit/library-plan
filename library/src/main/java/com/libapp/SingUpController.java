package com.libapp;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.libapp.controllersFunctions.CommonFunctions;
import com.libapp.controllersFunctions.CommonFunctionsImpl;
import com.libapp.service.HibernateUtil;
import com.libapp.service.Service;
import com.libapp.service.ServiceImpl;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;

public class SingUpController implements Initializable{
	private CommonFunctions windowFunction;
	 private Logger LOGGER=LogManager.getLogger(SingUpController.class);
	
	@FXML
	private Label lb_register;
	public static Label static_label;


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
    	windowFunction=new CommonFunctionsImpl();
    	Service<User> userService = new ServiceImpl<User>(User.class, HibernateUtil.getSessionFactory());
    	Service<Role> roleSer = new ServiceImpl<Role>(Role.class, HibernateUtil.getSessionFactory());
    	
    	String name=tf_name.getText();
    	String email=tf_email_up.getText();
    	String pass=pf_pass_up.getText();
    	String phone=tf_phone.getText();
    	
		if(name.length() <6 || email.isEmpty() ||
   			 phone.length()<10 || pass.length()<6)
        {
        	Alert alert=new Alert(AlertType.ERROR);
        	alert.setHeaderText(null);
        	alert.setContentText("Fill all required fields!Username and password -6 symbols,phone must be 10 numbers!");
        	alert.showAndWait();
        }
		
   	 else {
   		 
        if(checkUser(userService, name, email)==true)
        {
        	User user=new User(name,email,phone,pass,null);
        	Role role=new Role();
        	role=checkRole(roleSer);
        	Date utilDate=new Date();
        	java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        	user.setRegistrationDate(sqlDate);
        if(role!=null) 
        {	
        	user.setUserRole(role);	
        	
        }
        else {
        	role=new Role(App.getControllerRole());
        	 user.setUserRole(role);
        }
        LOGGER.info("User: "+ user.getUserName()+" registered in DB!");
        windowFunction.alertForSearchUser("Registartion succsessfuly!");
		         userService.save(user);    
			}
        else {
        	Alert alert=new Alert(AlertType.ERROR);
        	alert.setHeaderText(null);
        	windowFunction.alertForSearchUser("Registartion unsuccsessfuly!");
        	alert.setContentText("This User already exists!");
        	alert.showAndWait();
        }
   	 }	
		}
    
    private boolean checkUser(Service<User> userService,String name,String email) {
    	
    	Map<Integer, Object> dataUser = new HashMap<Integer, Object>();
        dataUser.put(0, name);
        dataUser.put(1, email);
        User user1= userService.namedQuery("User.Registration", dataUser);
        
    	if(user1==null)
        {	
    		return true;
        }
        else 
        	return false;
 
    }
    
    private Role checkRole(Service<Role> roleSer) {
    	
    	Map<Integer, Object> data = new HashMap<Integer, Object>();
        data.put(0, App.getControllerRole());
    	Role role=roleSer.namedQuery("Role.Check", data);
    	
    	 if(role!=null)
    	 {
    		 return role;
    	 }
    	 else return null;
    }

    @FXML
    void goToLogIn(ActionEvent event) {
    	windowFunction=new CommonFunctionsImpl();
		LOGGER.info("From registration form to login!");
		windowFunction.logOut(event,"\\com\\libapp\\signIn");
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		static_label=lb_register;
	}
    }

