package com.example.cincuentazo.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the GameModel.
 */
class GameModelTest {

    private GameModel gameModel;

    /**
     * Initializes a new GameModel instance before each test.
     */
    @BeforeEach
    void setUp() {
        gameModel = new GameModel();
    }

    /**
     * Test for the getDificulty method.
     * Verifies that the difficulty level is correctly retrieved.
     */
    @Test
    void testGetDificulty() {
        gameModel.setDificulty(3);
        assertEquals(3, gameModel.getDificulty(), "The difficulty level should be 3.");
    }
}
