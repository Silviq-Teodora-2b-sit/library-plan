package com.libapp;

import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.StageStyle;


public class App extends Application {
	public static String role;
	
    
	public static void main(String args[]) {
		Application.launch(args);
	}
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Parent root= FXMLLoader.load(getClass().getResource("signIn.fxml"));
		primaryStage.initStyle(StageStyle.DECORATED);
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static String getControllerRole() {
		 return role;
	}

	public static void setControllerRole(String passedRole) {
		 App.role = passedRole;
	}
}
