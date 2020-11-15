package com.libapp;

import java.io.IOException;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


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
			e.printStackTrace();
		}
	
		 bp.setCenter(root);
	}
	
}