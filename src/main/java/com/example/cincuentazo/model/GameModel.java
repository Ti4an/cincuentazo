package com.example.cincuentazo.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameModel {
    private ArrayList<Card> tableDeck;
    private ArrayList<Card> playerDeck;
    private ArrayList<ArrayList<Card>> machinesDeck;
    int dificulty;
    Deck deck;


    public GameModel() {
        playerDeck = new ArrayList<>();
        tableDeck = new ArrayList<>();
        machinesDeck = new ArrayList<>();
        deck = new Deck();


        for(int i = 0; i < 4; i++) {
            Card playerCard = deck.dealCard();
            playerDeck.add(playerCard);
        }

        for(int i = 0; i < getDificulty(); i++) {

            ArrayList<Card> machineDeck = new ArrayList<>();

            for(int j = 0; j < 4; j++) {
                Card machineCard = deck.dealCard();
                machineDeck.add(machineCard);
            }

            machinesDeck.add(machineDeck);
        }

        Card gameCard = deck.dealCard();
        tableDeck.add(gameCard);
    }

    public int getDificulty() {
        return dificulty;
    }

    public void setDificulty(int dificulty) {
        this.dificulty = dificulty;
    }



    public List<Card> getMainDeck() {
        return deck.getCards();
    }

    public ArrayList<Card> getTableDeck() {
        return tableDeck;
    }

    public ArrayList<Card> getPlayerDeck() {
        return playerDeck;
    }

    public ArrayList<ArrayList<Card>> machinesDeck() {
        return machinesDeck;
    }
    public Deck getDeck() {
        return deck;
    }
}
