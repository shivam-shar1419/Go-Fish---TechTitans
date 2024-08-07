/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The group of cards, stored in an ArrayList
 * 
 * @autor tech titans
 */
public class GroupOfCards {
    private final List<Card> cards;
    private final int size;

    public GroupOfCards(int size) {
        this.size = size;
        this.cards = new ArrayList<>(size); 
        
      
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        Rank[] ranks = Rank.values();
        
        for (String suit : suits) {
            for (Rank rank : ranks) {
                if (cards.size() < size) {
                    cards.add(new StandardCard(rank, Suit.valueOf(suit.toUpperCase())));
                }
            }
        }
    }

    public List<Card> getCards() {
        return cards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public int getSize() {
        return cards.size();
    }
}
