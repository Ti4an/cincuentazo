package com.example.cincuentazo.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class DificultView extends Stage {
    public DificultView() throws IOException{
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/example/cincuentazo/Dificultad.fxml"));
        Parent root = (Parent) loader.load();
        Scene scene = new Scene(root);
        this.setTitle("Cincuentazo");
        this.getIcons().add(new Image(this.getClass().getResourceAsStream("/com/example/cincuentazo/img/poker-table.png")));
        this.setScene(scene);
        this.show();
    }
    public static DificultView getInstance() throws IOException {
        if(DificultViewHolder.INSTANCE==null){
            return DificultView.DificultViewHolder.INSTANCE = new DificultView();
        }else{
            return DificultViewHolder.INSTANCE;
        }
    }

    private static class DificultViewHolder {
        private static DificultView INSTANCE;
    }
}
