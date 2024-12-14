package com.example.cincuentazo.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents the game model, managing the decks of cards for the player, machines, and the table.
 */
public class GameModel {
    private ArrayList<Card> tableDeck;
    private ArrayList<Card> playerDeck;
    private ArrayList<ArrayList<Card>> machinesDeck;
    private int dificulty;
    private Deck deck;

    /**
     * Initializes a new game model, dealing cards for the player and machines, and placing an initial card on the table.
     */
    public GameModel() {
        playerDeck = new ArrayList<>();
        tableDeck = new ArrayList<>();
        machinesDeck = new ArrayList<>();
        deck = new Deck();

        // Deal 4 cards to the player
        for (int i = 0; i < 4; i++) {
            Card playerCard = deck.dealCard();
            playerDeck.add(playerCard);
        }

        // Deal 4 cards to each machine according to the difficulty level
        for (int i = 0; i < getDificulty(); i++) {
            ArrayList<Card> machineDeck = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                Card machineCard = deck.dealCard();
                machineDeck.add(machineCard);
            }
            machinesDeck.add(machineDeck);
        }

        // Deal one card to the table to start the game
        Card gameCard = deck.dealCard();
        tableDeck.add(gameCard);
    }

    /**
     * Gets the current difficulty level of the game.
     *
     * @return The difficulty level.
     */
    public int getDificulty() {
        return dificulty;
    }

    /**
     * Sets the difficulty level of the game.
     *
     * @param dificulty The difficulty level to set.
     */
    public void setDificulty(int dificulty) {
        this.dificulty = dificulty;
    }

    /**
     * Gets the main deck of cards used in the game.
     *
     * @return The main deck of cards.
     */
    public List<Card> getMainDeck() {
        return deck.getCards();
    }

    /**
     * Gets the deck of cards on the table.
     *
     * @return The table deck of cards.
     */
    public ArrayList<Card> getTableDeck() {
        return tableDeck;
    }

    /**
     * Gets the player's deck of cards.
     *
     * @return The player's deck of cards.
     */
    public ArrayList<Card> getPlayerDeck() {
        return playerDeck;
    }

    /**
     * Gets the decks of cards for the machines.
     *
     * @return The list of machine decks.
     */
    public ArrayList<ArrayList<Card>> machinesDeck() {
        return machinesDeck;
    }

    /**
     * Gets the deck instance that contains all the cards for the game.
     *
     * @return The deck instance.
     */
    public Deck getDeck() {
        return deck;
    }
}
