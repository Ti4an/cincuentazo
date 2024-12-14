package com.example.cincuentazo.controller;

import com.example.cincuentazo.model.Card;
import com.example.cincuentazo.model.GameModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class GameController {

    private GameController gameController;
    private GameModel gameModel;
    int difficult;

    @FXML
    private Label CountMesa;

    @FXML
    private ImageView cardview;

    @FXML
    private Button cardButton1;

    @FXML
    private Button cardButton2;

    @FXML
    private Button cardButton3;

    @FXML
    private Button cardButton4;


    public void setGameModel(GameModel gameModel) {
        this.gameModel = gameModel;
        difficult = this.gameModel.getDificulty();
        System.out.println(difficult);

        updatePlayerDeck();
    }

    public void updatePlayerDeck() {
        // Obtener la mano del jugador
        ArrayList<Card> playerDeck = gameModel.getPlayerDeck();

        // Crear y asignar las imágenes a cada botón
        setCardImage(cardButton1, playerDeck.get(0));
        setCardImage(cardButton2, playerDeck.get(1));
        setCardImage(cardButton3, playerDeck.get(2));
        setCardImage(cardButton4, playerDeck.get(3));
    }

    private void setCardImage(Button button, Card card) {
        ImageView imageView = new ImageView(card.cargarImagen(card.getValor(), card.getPalo()));
        imageView.setFitWidth(100); // Ajusta el ancho de la imagen
        imageView.setFitHeight(150); // Ajusta el alto de la imagen
        button.setGraphic(imageView); // Asigna la imagen al botón
    }

    @FXML
    void CardButton(ActionEvent event) {

    }

    @FXML
    void OnCardFour(ActionEvent event) {
        playCard(3);

    }

    @FXML
    void OnCardOne(ActionEvent event) {
        playCard(0);

    }

    @FXML
    void OnCardThree(ActionEvent event) {
        playCard(2);
    }

    @FXML
    void OnCardTwo(ActionEvent event) {
        playCard(1);

    }

    private void playCard(int cardIndex) {
        // Jugar la carta seleccionada
        Card playedCard = gameModel.getPlayerDeck().remove(cardIndex);
        gameModel.getTableDeck().add(playedCard);

        // Tomar una nueva carta del mazo
        if (!gameModel.getMainDeck().isEmpty()) {
            gameModel.getPlayerDeck().add(cardIndex, gameModel.getMainDeck().remove(0));
        }

        // Actualizar las imágenes de los botones
        updatePlayerDeck();
    }

    @FXML
    void OnExitButton(ActionEvent event) {

    }

    public GameController getGameController() {
        return this.gameController;
    }

}



