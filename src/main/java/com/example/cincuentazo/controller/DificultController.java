package com.example.cincuentazo.controller;

import com.example.cincuentazo.view.DificultView;
import com.example.cincuentazo.view.GameView;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;


public class DificultController {
    @FXML
    private Button button;

    @FXML
    void onOneDificult(ActionEvent event) throws IOException {
        Stage stage = (Stage)this.button.getScene().getWindow();
        stage.close();
        GameView.getInstance();
    }

    @FXML
    void onTwoDificult(ActionEvent event) throws IOException {
        Stage stage = (Stage)this.button.getScene().getWindow();
        stage.close();
        GameView.getInstance();
    }

    @FXML
    void onThreeDificult(ActionEvent event) throws IOException {
        Stage stage = (Stage)this.button.getScene().getWindow();
        stage.close();
        GameView.getInstance();
    }

}
