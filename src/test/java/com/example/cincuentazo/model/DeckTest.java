package com.example.cincuentazo.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

/**
 * Test class for {@link Deck}.
 *
 * This class contains unit tests to verify that the deck of cards is correctly
 * initialized and contains the expected 52 cards. It ensures that the deck
 * contains all possible combinations of suits and values.
 */
class DeckTest {

    private Deck deck;

    /**
     * Method that runs before each test.
     * Initializes a new instance of {@link Deck}.
     */
    // Create a new instance of Deck before each test
    @BeforeEach
    void setUp() {
        deck = new Deck();
    }

    /**
     * Test to verify that the deck of cards is correctly initialized.
     *
     * This test verifies that the deck contains exactly 52 cards,
     * and that each card in the deck is a valid combination of one of the
     * 4 suits ("corazon", "diamante", "trebol", "pica") and one of the 13 values
     * ("2", "3", "4", ..., "a").
     */
    @Test
    void testInitializeDeck() {
        List<Card> cards = deck.getCards();

        assertEquals(52, cards.size(), "The deck must contain 52 cards");

        String[] suits = {"corazon", "diamante", "trebol", "pica"};
        String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "j", "q", "k", "a"};

        for (String suit : suits) {
            for (String value : values) {
                boolean found = false;
                for (Card card : cards) {
                    if (card.getPalo().equals(suit) && card.getValor().equals(value)) {
                        found = true;
                        break;
                    }
                }
                assertTrue(found, "The deck must contain the card: " + value + " of " + suit);
            }
        }
    }
}
