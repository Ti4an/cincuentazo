package com.example.cincuentazo.controller;

import com.example.cincuentazo.model.GameModel;
import javafx.fxml.FXML;

public class GameController {

    private GameController gameController;
    private GameModel gameModel;

    public GameController getGameController() {
        return this.gameController;
    }

    public void setGameModel(GameModel gameModel) {
        this.gameModel = gameModel;
        int difficult = this.gameModel.getDificulty();
        System.out.println(difficult);
    }
   /*
    private int difficulty;

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
        initializeGame();
    }

    private void initializeGame() {
        System.out.println("Game starting with difficulty: " + difficulty);

        // Aquí agrega la lógica para inicializar el juego con la dificultad seleccionada
    }

    @FXML
    public void initialize() {
        // Este método es llamado automáticamente después de cargar la vista
        // Pero la dificultad será pasada después, así que la lógica del juego
        // se maneja en `setDifficulty`.
    }
    */
}
