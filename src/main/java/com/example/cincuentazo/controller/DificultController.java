package com.example.cincuentazo.controller;

import com.example.cincuentazo.model.GameModel;
import com.example.cincuentazo.view.DificultView;
import com.example.cincuentazo.view.GameView;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;


public class DificultController {
    int difficulty;

    @FXML
    private Button button;

    /**
     * Handles the event when the player selects the "One" difficulty.
     * Closes the DificultView, creates a new GameModel, and sets the difficulty to 1.
     *
     * @param event The action event triggered by the button click
     * @throws IOException If an I/O error occurs while closing the view or setting the game model
     */
    @FXML
    void onOneDificult(ActionEvent event) throws IOException {
        DificultView.getInstance().close();
        GameModel gameModel = new GameModel();
        gameModel.setDificulty(1);
        GameView.getInstance().getGameController().setGameModel(gameModel);
    }

    /**
     * Handles the event when the player selects the "Two" difficulty.
     * Closes the DificultView, creates a new GameModel, and sets the difficulty to 2.
     *
     * @param event The action event triggered by the button click
     * @throws IOException If an I/O error occurs while closing the view or setting the game model
     */
    @FXML
    void onTwoDificult(ActionEvent event) throws IOException {
        DificultView.getInstance().close();
        GameModel gameModel = new GameModel();
        gameModel.setDificulty(2);
        GameView.getInstance().getGameController().setGameModel(gameModel);
    }

    /**
     * Handles the event when the player selects the "Three" difficulty.
     * Closes the DificultView, creates a new GameModel, and sets the difficulty to 3.
     *
     * @param event The action event triggered by the button click
     * @throws IOException If an I/O error occurs while closing the view or setting the game model
     */
    @FXML
    void onThreeDificult(ActionEvent event) throws IOException {
        DificultView.getInstance().close();
        GameModel gameModel = new GameModel();
        gameModel.setDificulty(3);
        GameView.getInstance().getGameController().setGameModel(gameModel);
    }
}
