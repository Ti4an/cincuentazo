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



    public void setGameModel(GameModel gameModel) {
        this.gameModel = gameModel;
        difficult = this.gameModel.getDificulty();
        System.out.println(difficult);


        // Colocar una carta aleatoria en la mesa al iniciar el juego
        Card initialCard = gameModel.getDeck().dealCard(); // Obtener una carta aleatoria del mazo
        gameModel.getTableDeck().add(initialCard); // Agregar la carta a la mesa

        // Mostrar la carta inicial en el ImageView
        cardview.setImage(initialCard.cargarImagen(initialCard.getValor(), initialCard.getPalo()));

        // Actualizar el puntaje inicial según el valor de la carta inicial
        puntosTotales = initialCard.calcularPuntaje(initialCard.getValor());

        updatePuntosLabel();

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
        imageView.setFitWidth(64); // Ajusta el ancho de la imagen
        imageView.setFitHeight(83); // Ajusta el alto de la imagen
        button.setGraphic(imageView); // Asigna la imagen al botón
    }



    private void playCard(int cardIndex) throws IOException {
        // Jugar la carta seleccionada
        Card playedCard = gameModel.getPlayerDeck().remove(cardIndex);
        gameModel.getTableDeck().add(playedCard);

        // Mostrar la carta jugada en el ImageView "cardview"
        cardview.setImage(playedCard.cargarImagen(playedCard.getValor(), playedCard.getPalo()));
        cardview.setFitWidth(64); // Ajusta el ancho del ImageView (opcional)
        cardview.setFitHeight(83); // Ajusta el alto del ImageView (opcional)
        cardview.setPreserveRatio(true); // Mantiene las proporciones de la imagen

        int puntosCarta = playedCard.calcularPuntaje(playedCard.getValor());
        puntosTotales += puntosCarta; // Acumular el puntaje

        // Mostrar los puntos acumulados en el Label
        updatePuntosLabel();

        // Verificar si el mazo está vacío y el jugador ganó
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


        // Tomar una nueva carta del mazo
        if (!gameModel.getMainDeck().isEmpty()) {
            gameModel.getPlayerDeck().add(cardIndex, gameModel.getMainDeck().remove(0));
        }

        // Actualizar las imágenes de los botones
        updatePlayerDeck();
    }


    /**
     * Deshabilita todos los botones de las cartas.
     */
    private void disableAllButtons() {
        cardButton1.setDisable(true);
        cardButton2.setDisable(true);
        cardButton3.setDisable(true);
        cardButton4.setDisable(true);
    }

    private void updatePuntosLabel() {
        puntos.setText(String.valueOf(puntosTotales));
    }


    @FXML
    void OnExitButton(ActionEvent event) throws IOException {
        GameView.getInstance().close();
    }

    public GameController getGameController() {
        return this.gameController;
    }

    @FXML
    void CardButton(ActionEvent event) {

    }

    @FXML
    void OnCardFour(ActionEvent event) throws IOException {
        playCard(3);

    }

    @FXML
    void OnCardOne(ActionEvent event) throws IOException {
        playCard(0);

    }

    @FXML
    void OnCardThree(ActionEvent event) throws IOException {
        playCard(2);
    }

    @FXML
    void OnCardTwo(ActionEvent event) throws IOException {
        playCard(1);

    }

}



