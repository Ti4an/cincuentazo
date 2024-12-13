package com.example.cincuentazo.controller;

import com.example.cincuentazo.view.DificultView;
import com.example.cincuentazo.view.HelpView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {

    @FXML
    private Button onPlay;


    @FXML
    private Button onExit;

    @FXML
    private Button onHow;

    @FXML
    private ImageView cincuentazoImage;

    public void initialize() {
        Image image = new Image(getClass().getResourceAsStream("/com/example/cincuentazo/img/play.jpg"));
        ImageView imageView = new ImageView(image);
        onPlay.setGraphic(imageView);
        Image image2 = new Image(getClass().getResourceAsStream("/com/example/cincuentazo/img/howTo.jpg"));
        ImageView imageView2 = new ImageView(image2);
        onHow.setGraphic(imageView2);
        Image image3 = new Image(getClass().getResourceAsStream("/com/example/cincuentazo/img/exit.jpg"));
        ImageView imageView3 = new ImageView(image3);
        onExit.setGraphic(imageView3);
        Image image4 = new Image(getClass().getResourceAsStream("/com/example/cincuentazo/img/title.png"));
        cincuentazoImage.setImage(image4);
    }

    @FXML
    void onExitButton(ActionEvent event) {
        Stage stage = (Stage)this.cincuentazoImage.getScene().getWindow();
        stage.close();
    }

    @FXML
    void onHowButtton(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        HelpView.getInstance(stage);
    }

    @FXML
    void onPlatButton(ActionEvent event) throws IOException {
        Stage stage = (Stage)this.cincuentazoImage.getScene().getWindow();
        stage.close();
        DificultView.getInstance();
    }
}

