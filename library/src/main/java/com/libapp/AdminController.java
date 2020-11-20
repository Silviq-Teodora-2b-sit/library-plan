package com.libapp;

import java.io.IOException;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class AdminController{
	   @FXML
	    private AnchorPane ap;

	    @FXML
	    private Pane pane;
    
    @FXML
    private void ScrappBook(ActionEvent event) { 
    	loadPage("");
    }

    @FXML
    private void addBook(ActionEvent event) {
    	loadPage("");
    }

    @FXML
    private void archiveBook(ActionEvent event) {
    	loadPage("");
    }

    @FXML
    private void borrowBook(ActionEvent event) {
    	loadPage("");
    }

    @FXML
    private void createOperators(ActionEvent event) {
    	App.setControllerRole("operator");
    	loadPage("saveUsers");
    }

    @FXML
    private void createReader(ActionEvent event) {
    	App.setControllerRole("reader");
    	loadPage("saveUsers");
    }

    @FXML
    void deleteReader(ActionEvent event) {
    	loadPage("");
    }
    
    @FXML
    private void refBook(ActionEvent event) {
    	loadPage("");
    }

    @FXML
    private void refForms(ActionEvent event) {
    	loadPage("");
    }

    @FXML
    private void refRating(ActionEvent event) {
    	loadPage("");
    }

    @FXML
    private void refUsers(ActionEvent event) {
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
	
	
}