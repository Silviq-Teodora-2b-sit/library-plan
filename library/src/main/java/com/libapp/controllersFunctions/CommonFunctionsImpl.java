package com.libapp.controllersFunctions;

import java.io.IOException;
import com.libapp.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CommonFunctionsImpl  implements CommonFunctions{

	@Override
	public void logOut(ActionEvent event, String page) {
		
		Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
		stage.close();
		Stage stage2=new Stage();
		App app=new App();
		try {
			app.start(stage2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void openWindow(String title) {
		Parent root = null;
		 try {
			root= FXMLLoader.load(getClass().getClassLoader().getResource(title+".fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		 Scene scene=new Scene(root);
		 Stage stage=new Stage(StageStyle.DECORATED);
		// stage.getIcons().add(new Image("\\com\\libapp\\1628609.png"));
		 stage.setScene(scene);
		 stage.show();
	}

	@Override
	public void alertForSearchUser(String alertText) {
		Alert alert=new Alert(AlertType.ERROR);
    	alert.setHeaderText(null);
    	alert.setContentText(alertText);
    	alert.showAndWait();
		
	}
	

	}
	


