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

public class GroupOfCardsTest {

    public GroupOfCardsTest() {
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
    public void testGroupOfCardsInitialization() {
        GroupOfCards group = new GroupOfCards(52);
        assertNotNull(group);
        assertEquals(52, group.getSize());
    }

    @Test
    public void testShuffle() {
        GroupOfCards group = new GroupOfCards(52);
        group.shuffle();
        assertNotNull(group.getCards());
        assertEquals(52, group.getCards().size()); 
    }
}
