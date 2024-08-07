/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 * Class representing a standard playing card.
 * 
 * @author tech titans
 */

public class StandardCard extends Card {
    private final Rank cardRank;
    private final Suit cardSuit;

    public StandardCard(Rank rank, Suit suit) {
        super(rank.toString(), suit.toString());
        this.cardRank = rank;
        this.cardSuit = suit;
    }

    @Override
    public String getRank() {
        return cardRank.toString();
    }

    @Override
    public String getSuit() {
        return cardSuit.toString();
    }

    @Override
    public String toString() {
        return cardRank + " of " + cardSuit;
    }
}
