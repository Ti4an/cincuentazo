package com.example.cincuentazo.controller;

import com.example.cincuentazo.view.HomeView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
    void onExitButton(ActionEvent event) throws IOException {
        HomeView.getInstance().close(); // Close the word input view

    }

    @FXML
    void onHowButtton(ActionEvent event) {

    }

    @FXML
    void onPlatButton(ActionEvent event) {

    }
}

