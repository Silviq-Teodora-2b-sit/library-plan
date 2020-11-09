package com.libapp;

//import java.awt.event.ActionEvent;
import javafx.event.ActionEvent;

import java.io.IOException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
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
        	
        	UserDAO u=new UserDAO();
    		u.openCurrentSession();
        	User user=u.Validation(email, pass);
    		u.closeCurrentSession();
    		
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