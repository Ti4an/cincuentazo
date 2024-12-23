package com.example.cincuentazo.controller;

import com.example.cincuentazo.view.Alert.AlertBox;
import com.example.cincuentazo.view.DificultView;
import com.example.cincuentazo.view.HomeView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller for the home screen of the game, handling the navigation and displaying game instructions.
 */
public class HomeController {

    @FXML
    private Button onPlay;

    @FXML
    private Button onExit;

    @FXML
    private Button onHow;

    @FXML
    private ImageView cincuentazoImage;

    private String Rules = """
                Objective:
                Be the last player standing by avoiding the total sum of cards on the table exceeding 50 points.
                
                Preparation:
                - Each player is dealt 4 cards.
                - One initial card is placed face up on the table, starting the sum.
                - The remaining cards form the deck, placed face down.
                
                Main Rules:
                - On your turn, play a card from your hand that does not cause the sum to exceed 50.
                - Card effects:
                  • 2-8 and 10: Add their number to the sum.
                  • 9: Does not affect the sum.
                  • J, Q, K: Subtract 10 from the sum.
                  • A: Adds either 1 or 10, whichever is more convenient.
                - After playing a card, draw one from the deck to keep 4 cards in your hand.
                
                Elimination:
                - If you cannot play any card without exceeding 50, you are eliminated.
                
                End of the Game:
                - The game ends when only one player remains. That player is the winner.
                """;

    /**
     * Initializes the home screen, setting up the images for buttons and title.
     */
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

    /**
     * Handles the exit button action, closing the home view.
     *
     * @param event The action event triggered by pressing the exit button.
     * @throws IOException If an error occurs while closing the view.
     */
    @FXML
    void onExitButton(ActionEvent event) throws IOException {
        HomeView.getInstance().close();
    }

    /**
     * Displays the game instructions in an alert box when the "How to play" button is pressed.
     *
     * @param event The action event triggered by pressing the "How to play" button.
     */
    @FXML
    void onHowButtton(ActionEvent event) {
        new AlertBox().InformationAlert("Cincuentazo", "HOW TO PLAY?", Rules);
    }

    /**
     * Navigates to the difficulty selection screen when the "Play" button is pressed.
     *
     * @param event The action event triggered by pressing the play button.
     * @throws IOException If an error occurs while navigating to the difficulty view.
     */
    @FXML
    void onPlatButton(ActionEvent event) throws IOException {
        HomeView.getInstance().close();
        DificultView.getInstance();
    }
}
