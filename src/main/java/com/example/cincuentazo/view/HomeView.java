package com.example.cincuentazo.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class HomeView extends Stage {
    public HomeView() throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/example/cincuentazo/home-view.fxml"));
        Parent root = (Parent)loader.load();
        Scene scene = new Scene(root);
        this.initStyle(StageStyle.UNDECORATED);
        this.setTitle("Cincuentazo");
        this.getIcons().add(new Image(this.getClass().getResourceAsStream("/com/example/cincuentazo/img/poker-table.png")));
        this.setScene(scene);
        this.show();
    }

    public static HomeView getInstance() throws IOException {
        if(HomeViewHolder.INSTANCE== null){
            return HomeView.HomeViewHolder.INSTANCE = new HomeView();
        }else{
            return HomeViewHolder.INSTANCE;
        }

    }

    private static class HomeViewHolder {
        private static HomeView INSTANCE;
    }
}
