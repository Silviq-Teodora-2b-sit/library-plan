package com.libapp;

//import java.awt.event.ActionEvent;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.libapp.service.HibernateUtil;
import com.libapp.service.Service;
import com.libapp.service.ServiceImpl;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Node;


public class SignInController {

    @FXML
    private TextField tf_email_in;

    @FXML
    private PasswordField tf_pass_in;

    @FXML
    private Button btn_signIN;

    @FXML
    void onSignINClick(ActionEvent event) {
    	String email=tf_email_in.getText();
        String pass=tf_pass_in.getText();
        
        if(email.isEmpty() || pass.isEmpty())
        {
        	Alert alert=new Alert(AlertType.ERROR);
        	alert.setHeaderText(null);
        	alert.setContentText("Fill all required fields!");
        	alert.showAndWait();
        }
        else {
    		
    		Service<User> userService = new ServiceImpl<User>(User.class, HibernateUtil.getSessionFactory());
    		 Map<Integer, Object> data = new HashMap<Integer, Object>();
	         data.put(0, email);
	         data.put(1, pass);
	         
	         User user=userService.namedQuery("User.byEmailAndPass", data);
    		
    	if(user!=null)
    	{
    		((Node)event.getSource()).getScene().getWindow().hide();
    		loadWindow("admin");
    	}
    	else {

        	Alert alert=new Alert(AlertType.ERROR);
        	alert.setHeaderText(null);
        	alert.setContentText("Incorrect email or password!");
        	alert.showAndWait();
    	}
        }
    	
    }
    
    private void loadWindow(String title) {
    	Parent root = null;
		 try {
			root= FXMLLoader.load(getClass().getResource(title+".fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 Scene scene= new Scene(root);
		 Stage stage=new Stage(StageStyle.DECORATED);
		 stage.setScene(scene);
		 stage.show();
    }

}