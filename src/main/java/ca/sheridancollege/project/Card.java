/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

/**
 * A class to be used as the base Card class for the project. Must be general enough to be instantiated for any Card
 * game. Students wishing to add to the code should remember to add themselves as a modifier.
 *
 * @author dancye
 * @author [Tech Titans] 
 */
public abstract class Card {
    protected String rank;
    protected String suit;

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }


    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    @Override
    public abstract String toString();
}
