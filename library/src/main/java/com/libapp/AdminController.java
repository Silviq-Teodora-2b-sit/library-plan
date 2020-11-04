package com.libapp;

//import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.Event;


import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
//import javafx.scene.control.Button;

public class AdminController{


    @FXML
    private BorderPane bp;

    @FXML
    private AnchorPane ap;
    
    
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
    	bp.setCenter(ap);
    }

    @FXML
    private void createReader(ActionEvent event) {
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		 bp.setCenter(root);
	}
	
}