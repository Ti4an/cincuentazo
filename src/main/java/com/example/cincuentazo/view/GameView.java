package com.example.cincuentazo.view;

import com.example.cincuentazo.controller.GameController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class GameView extends Stage {

    private GameController gameController;

    public GameView() throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/example/cincuentazo/game-view.fxml"));
        Parent root = (Parent)loader.load();
        this.gameController = (GameController)loader.getController();
        Scene scene = new Scene(root);
        //this.initStyle(StageStyle.UNDECORATED);
        this.setTitle("Cincuentazo");
        this.getIcons().add(new Image(this.getClass().getResourceAsStream("/com/example/cincuentazo/img/poker-table.png")));
        this.setScene(scene);
        this.show();
    }

    public GameController getGameController() {
        return this.gameController;
    }

    public static GameView getInstance() throws IOException {
        if(GameView.GameViewHolder.INSTANCE==null){
            return GameView.GameViewHolder.INSTANCE = new GameView();
        }else{
            return GameView.GameViewHolder.INSTANCE;
        }
    }

    private static class GameViewHolder {
        private static GameView INSTANCE;
    }


}
