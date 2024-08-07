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

public class StandardCardTest {

    public StandardCardTest() {
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
    public void testStandardCardCreation() {
        Card card = new StandardCard(Rank.ACE, Suit.HEARTS);
        assertNotNull(card);
    }

    @Test
    public void testGetSuit() {
        Card card = new StandardCard(Rank.ACE, Suit.HEARTS);
        assertEquals(Suit.HEARTS.toString(), card.getSuit());
    }

    @Test
    public void testGetRank() {
        Card card = new StandardCard(Rank.ACE, Suit.HEARTS);
        assertEquals(Rank.ACE.toString(), card.getRank());
    }
}
