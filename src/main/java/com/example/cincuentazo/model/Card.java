package com.example.cincuentazo.model;

import javafx.scene.image.Image;

/**
 * This class represents a card in the game.
 * It stores the card's value (e.g., "A", "J", "K"), suit (e.g., "hearts", "diamonds"),
 * score (calculated based on the value), and an associated image.
 */
public class Card {
    private String valor;
    private String palo;
    private int puntaje;
    private Image imagen;

    /**
     * Constructor to create a new Card instance with the specified value and suit.
     * The score and image are calculated based on the value and suit.
     *
     * @param valor The value of the card (e.g., "A", "J", "K")
     * @param palo The suit of the card (e.g., "hearts", "diamonds")
     */
    public Card(String valor, String palo) {
        this.valor = valor;
        this.palo = palo;
        this.puntaje = calcularPuntaje(valor);
        this.imagen = cargarImagen(valor, palo);
    }

    /**
     * Calculates the score for the card based on its value.
     *
     * @param valor The value of the card (e.g., "A", "J", "K")
     * @return The score corresponding to the card's value
     */
    public int calcularPuntaje(String valor) {
        switch (valor) {
            case "a": return 1;
            case "j": return -10;
            case "q": return -10;
            case "k": return -10;
            case "9": return 0;
            default: return Integer.parseInt(valor);
        }
    }

    /**
     * Loads the image corresponding to the card based on its value and suit.
     *
     * @param valor The value of the card (e.g., "A", "J", "K")
     * @param palo The suit of the card (e.g., "hearts", "diamonds")
     * @return The image of the card, or null if the image file is not found
     */
    public Image cargarImagen(String valor, String palo) {
        String ruta = "/com/example/cincuentazo/cards/" + valor + "-" + palo.toLowerCase() + ".png";
        if (getClass().getResourceAsStream(ruta) == null) {
            System.err.println("File not found: " + ruta);
            return null;
        }
        return new Image(getClass().getResourceAsStream(ruta));
    }

    /**
     * Gets the value of the card.
     *
     * @return The value of the card
     */
    public String getValor() {
        return valor;
    }

    /**
     * Gets the suit of the card.
     *
     * @return The suit of the card
     */
    public String getPalo() {
        return palo;
    }

    /**
     * Gets the score of the card.
     *
     * @return The score of the card
     */
    public int getPuntaje() {
        return puntaje;
    }

    /**
     * Gets the image of the card.
     *
     * @return The image of the card
     */
    public Image getImagen() {
        return imagen;
    }

    /**
     * Returns a string representation of the card, displaying its value and suit.
     *
     * @return A string representation of the card
     */
    @Override
    public String toString() {
        return valor + " de " + palo;
    }
}
