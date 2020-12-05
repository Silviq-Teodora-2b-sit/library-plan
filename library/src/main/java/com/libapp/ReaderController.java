package com.libapp;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.libapp.controllersFunctions.CommonFunctions;
import com.libapp.controllersFunctions.CommonFunctionsImpl;

import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;

public class ReaderController extends SingUpController implements Initializable{
	private CommonFunctions windowFunction;
	 private Logger LOGGER=LogManager.getLogger(OperatorController.class);

	  @FXML
	    private AnchorPane ap;

	  @FXML
	    private Pane pane;
	  
	  @FXML
	  private Label userName;

	  @FXML
	    private Label user;
	    
   
   @FXML
   private void borrowBook(ActionEvent event) {
   	loadPage("");
   }

   @FXML
   private void refBook(ActionEvent event) {
   	loadPage("");
   }


   @FXML
  private  void returnBook(ActionEvent event) {
   	loadPage("");
   }

	private void loadPage(String page) {
		Parent root = null;
		 try {
			root= FXMLLoader.load(getClass().getResource(page+".fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		 pane.getChildren().add(root);
		 
	}
	
	@FXML
   void logOut(ActionEvent event) {
		windowFunction=new CommonFunctionsImpl();
		LOGGER.info("User: "+userName.getText()+" logout from the system!");
		windowFunction.logOut(event,"\\com\\libapp\\signIn");
		
   }
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	userName.setText(SignInController.saveUser.getUserName());
	user.setText(SignInController.saveUser.getUserName());
	}


}
