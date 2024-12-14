package com.example.cincuentazo.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Clase que representa un mazo de cartas de póker
public class Deck {
    private List<Card> cards; // Lista que contiene todas las cartas en el mazo

    // Constructor que inicializa el mazo
    public Deck() {
        this.cards = new ArrayList<>();
        initializeDeck(); // Llena el mazo con todas las cartas posibles
        shuffle(); // Baraja las cartas al inicio
    }

    // Método para inicializar el mazo con todas las cartas estándar
    private void initializeDeck() {
        String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"}; // Valores de las cartas
        String[] suits = {"corazon", "diamante", "trebol", "pica"}; // Palos de las cartas

        // Itera sobre todos los palos y valores para crear las cartas
        for (String suit : suits) {
            for (String value : values) {
                cards.add(new Card(value, suit)); // Crea y agrega una nueva carta al mazo
            }
        }
    }

    // Método para barajar las cartas
    public void shuffle() {
        Collections.shuffle(cards); // Mezcla aleatoriamente las cartas en el mazo
    }

    // Método para repartir una carta desde el mazo
    public Card dealCard() {
        if (!cards.isEmpty()) {
            return cards.remove(cards.size() - 1); // Devuelve y elimina la última carta del mazo
        }
        return null; // Si no hay cartas, devuelve null
    }

    // Método para agregar cartas al mazo (útil cuando se reciclan cartas)
    public void addCards(List<Card> newCards) {
        cards.addAll(newCards); // Agrega nuevas cartas al mazo
        shuffle(); // Baraja nuevamente el mazo después de agregar las cartas
    }

    // Método para verificar cuántas cartas quedan en el mazo
    public int remainingCards() {
        return cards.size(); // Devuelve el número de cartas restantes
    }

    public List<Card> getCards() {
        return cards;
    }

}
