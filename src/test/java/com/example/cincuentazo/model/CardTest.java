package com.example.cincuentazo.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Unit test class for the {@link Card} class.
 * This class contains tests for the {@link Card#getPuntaje()} method to ensure correct score calculation.
 */
class CardTest {

    /**
     * Constructor for CardTest class.
     */
    CardTest() {
    }

    /**
     * Tests the {@link Card#getPuntaje()} method for various card values.
     * It checks if the score calculation is correct for cards with values 'a', 'j', 'q', 'k', '9', '5', and '3'.
     * It also verifies that an exception is thrown for an invalid card value 'z'.
     */
    @Test
    void testCalcularPuntaje() {
        Card cardA = new Card("a", "corazon");
        Assertions.assertEquals(1, cardA.getPuntaje(), "'a' debe devolver 1");

        Card cardJ = new Card("j", "diamante");
        Assertions.assertEquals(-10, cardJ.getPuntaje(), "'j' debe devolver -10");

        Card cardQ = new Card("q", "pica");
        Assertions.assertEquals(-10, cardQ.getPuntaje(), "'q' debe devolver -10");

        Card cardK = new Card("k", "trebol");
        Assertions.assertEquals(-10, cardK.getPuntaje(), "'k' debe devolver -10");

        Card card9 = new Card("9", "corazon");
        Assertions.assertEquals(0, card9.getPuntaje(), "'9' debe devolver 0");

        Card card5 = new Card("5", "pica");
        Assertions.assertEquals(5, card5.getPuntaje(), "'5' debe devolver 5");

        Card card3 = new Card("3", "trebol");
        Assertions.assertEquals(3, card3.getPuntaje(), "'3' debe devolver 3");

        Assertions.assertThrows(NumberFormatException.class, () -> {
            new Card("z", "corazon");
        }, "'z' debe lanzar una excepción");
    }
}
