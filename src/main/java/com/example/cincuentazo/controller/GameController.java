package com.example.cincuentazo.controller;

import com.example.cincuentazo.model.Card;
import com.example.cincuentazo.model.GameModel;
import com.example.cincuentazo.view.Alert.AlertBox;
import com.example.cincuentazo.view.DificultView;
import com.example.cincuentazo.view.GameView;
import com.example.cincuentazo.view.HomeView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Controller for handling game logic, card actions, and player interactions.
 */
public class GameController {
    private int puntosTotales = 0;
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

    @FXML
    private ImageView maquinaDos;

    @FXML
    private ImageView maquinaTres;

    @FXML
    private ImageView maquinaUno;

    @FXML
    private Label puntos;

    /**
     * Sets the game model and initializes the game by dealing an initial card and updating the player's deck.
     *
     * @param gameModel The model representing the game.
     */
    public void setGameModel(GameModel gameModel) {
        this.gameModel = gameModel;
        difficult = this.gameModel.getDificulty();
        System.out.println(difficult);

        Card initialCard = gameModel.getDeck().dealCard();
        gameModel.getTableDeck().add(initialCard);

        cardview.setImage(initialCard.cargarImagen(initialCard.getValor(), initialCard.getPalo()));

        puntosTotales = initialCard.calcularPuntaje(initialCard.getValor());

        updatePuntosLabel();
        updatePlayerDeck();
    }

    /**
     * Updates the player's deck by displaying the card images on the corresponding buttons.
     */
    public void updatePlayerDeck() {
        ArrayList<Card> playerDeck = gameModel.getPlayerDeck();

        setCardImage(cardButton1, playerDeck.get(0));
        setCardImage(cardButton2, playerDeck.get(1));
        setCardImage(cardButton3, playerDeck.get(2));
        setCardImage(cardButton4, playerDeck.get(3));
    }

    /**
     * Sets the image of a button based on the given card.
     *
     * @param button The button to set the image for.
     * @param card The card to retrieve the image from.
     */
    private void setCardImage(Button button, Card card) {
        ImageView imageView = new ImageView(card.cargarImagen(card.getValor(), card.getPalo()));
        imageView.setFitWidth(64);
        imageView.setFitHeight(83);
        button.setGraphic(imageView);
    }

    /**
     * Handles the logic for playing a selected card, updates the table and player's deck, and checks win/lose conditions.
     *
     * @param cardIndex The index of the card to play from the player's deck.
     * @throws IOException If an error occurs while processing the card.
     */
    private void playCard(int cardIndex) throws IOException {
        Card playedCard = gameModel.getPlayerDeck().remove(cardIndex);
        gameModel.getTableDeck().add(playedCard);

        cardview.setImage(playedCard.cargarImagen(playedCard.getValor(), playedCard.getPalo()));
        cardview.setFitWidth(64);
        cardview.setFitHeight(83);
        cardview.setPreserveRatio(true);

        int puntosCarta = playedCard.calcularPuntaje(playedCard.getValor());
        puntosTotales += puntosCarta;

        updatePuntosLabel();

        if (gameModel.getMainDeck().isEmpty()) {
            new AlertBox().InformationAlert("¡Juego Ganado!", "¡Felicidades!","Has ganado el juego, el mazo se ha vaciado.");
            disableAllButtons();
            GameView.getInstance().close();
            return;
        }

        if (puntosTotales > 50) {
            new AlertBox().InformationAlert("Juego Terminado", "¡Has perdido!","El puntaje total ha superado 50.");
            disableAllButtons();
            GameView.getInstance().close();
            return;
        }

        if (!gameModel.getMainDeck().isEmpty()) {
            gameModel.getPlayerDeck().add(cardIndex, gameModel.getMainDeck().remove(0));
        }

        updatePlayerDeck();
    }

    /**
     * Disables all card buttons to prevent further actions after the game has ended.
     */
    private void disableAllButtons() {
        cardButton1.setDisable(true);
        cardButton2.setDisable(true);
        cardButton3.setDisable(true);
        cardButton4.setDisable(true);
    }

    /**
     * Updates the label displaying the total points accumulated by the player.
     */
    private void updatePuntosLabel() {
        puntos.setText(String.valueOf(puntosTotales));
    }

    /**
     * Closes the game view when the exit button is pressed.
     *
     * @param event The action event triggered by pressing the exit button.
     * @throws IOException If an error occurs while closing the view.
     */
    @FXML
    void OnExitButton(ActionEvent event) throws IOException {
        GameView.getInstance().close();
    }

    /**
     * Returns the current game controller instance.
     *
     * @return The GameController instance.
     */
    public GameController getGameController() {
        return this.gameController;
    }

    /**
     * Placeholder for handling card button actions (not implemented).
     *
     * @param event The action event triggered by pressing any card button.
     */
    @FXML
    void CardButton(ActionEvent event) {
    }

    /**
     * Handles the action when the fourth card button is pressed.
     *
     * @param event The action event triggered by pressing the fourth card button.
     * @throws IOException If an error occurs while playing the card.
     */
    @FXML
    void OnCardFour(ActionEvent event) throws IOException {
        playCard(3);
    }

    /**
     * Handles the action when the first card button is pressed.
     *
     * @param event The action event triggered by pressing the first card button.
     * @throws IOException If an error occurs while playing the card.
     */
    @FXML
    void OnCardOne(ActionEvent event) throws IOException {
        playCard(0);
    }

    /**
     * Handles the action when the third card button is pressed.
     *
     * @param event The action event triggered by pressing the third card button.
     * @throws IOException If an error occurs while playing the card.
     */
    @FXML
    void OnCardThree(ActionEvent event) throws IOException {
        playCard(2);
    }

    /**
     * Handles the action when the second card button is pressed.
     *
     * @param event The action event triggered by pressing the second card button.
     * @throws IOException If an error occurs while playing the card.
     */
    @FXML
    void OnCardTwo(ActionEvent event) throws IOException {
        playCard(1);
    }
}
