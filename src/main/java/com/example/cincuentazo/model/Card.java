package com.example.cincuentazo.model;

import javafx.scene.image.Image;

public class Card {
    private String valor;
    private String palo;
    private int puntaje;
    private Image imagen;

    public Card (String valor, String palo) {
        this.valor = valor;
        this.palo = palo;
        this.puntaje = calcularPuntaje(valor);
        this.imagen = cargarImagen(valor, palo);
    }

    private int calcularPuntaje(String valor) {
        switch (valor) {
            case "A": return 1; // op de valor 10
            case "J": return -10;
            case "Q": return -10;
            case "K": return -10;
            case "9": return 0;
            default: return Integer.parseInt(valor);
        }
    }

    private Image cargarImagen(String valor, String palo) {
        String ruta = "/com/example/cincuentazo/cards/" + valor + "-" + palo.toLowerCase() + ".png";
        return new Image(getClass().getResourceAsStream(ruta));
    }

    public String getValor() {
        return valor;
    }

    public String getPalo() {
        return palo;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public Image getImagen() {
        return imagen;
    }

    @Override
    public String toString() {
        return valor + " de " + palo;
    }
}

