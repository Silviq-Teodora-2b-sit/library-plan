package com.libapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class Library {

    @FXML
    private TextField tf_name;

    @FXML
    private TextField tf_rez;

    @FXML
    void onSubmitClick(ActionEvent event) {

    	tf_rez.setText(tf_name.getText());
    }

}