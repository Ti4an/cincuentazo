package com.example.cincuentazo;

import com.example.cincuentazo.view.HomeView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        HomeView.getInstance();
    }

    public static void main(String[] args) {
        launch();
    }
}