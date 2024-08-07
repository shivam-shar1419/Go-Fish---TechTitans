/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ca.sheridancollege.project;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author tech titans
 */

public class DeckTest {

    public DeckTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testDeckInitialization() {
        Deck deck = new Deck();
        assertNotNull(deck);
        assertEquals(52, deck.size());
    }

    @Test
    public void testDrawCard() {
        Deck deck = new Deck();
        Card card = deck.drawCard();
        assertNotNull(card);
        assertEquals(51, deck.size());
    }

    @Test
    public void testDrawCardEmptyDeck() {
        Deck deck = new Deck();
        while (deck.size() > 0) {
            deck.drawCard();
        }
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            deck.drawCard();
        });
        assertEquals("Cannot draw a card from an empty deck", exception.getMessage());
    }
}
