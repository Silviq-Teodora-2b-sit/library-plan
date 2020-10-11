package com.libapp;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.StageStyle;


public class Main extends Application {

	public static void main(String args[]) {
		Application.launch(args);
	}
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		/*Pane mainPane=(Pane) FXMLLoader.load(Main.class.getResource("D:\\java\\library\\src\\main\\signIn.fxml"));
		primaryStage.setScene(new Scene(mainPane));
		
		primaryStage.show();
	}*/
		Parent root= FXMLLoader.load(getClass().getResource("signup.fxml"));
		primaryStage.initStyle(StageStyle.DECORATED);
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	
}
}
