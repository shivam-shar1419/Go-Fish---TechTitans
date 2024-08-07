package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 * 
 * @author tech titans
 */
public abstract class Player {

    private String name; 
    protected List<Card> hand; 
    protected int score;


    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
        this.score = 0;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

 
    public abstract void play();


    public abstract void requestCard(Player targetPlayer, String rank, Deck deck);

    public void draw(Deck deck) {
        Card card = deck.drawCard();
        if (card != null) {
            hand.add(card);
        }
    }

 
    public void incrementScore() {
        score++;
    }


    public boolean hasSetofCards() {
        Map<String, Integer> rankCount = new HashMap<>();
        for (Card card : hand) {
            rankCount.put(card.getRank(), rankCount.getOrDefault(card.getRank(), 0) + 1);
        }
        boolean formedBook = false;
        for (Map.Entry<String, Integer> entry : rankCount.entrySet()) {
            if (entry.getValue() == 4) {
                removeCardsOfRank(entry.getKey());
                incrementScore();
                System.out.println(this.name + " has formed a book of " + entry.getKey() + "s!");
                formedBook = true;
            }
        }
        return formedBook;
    }

  
    private void removeCardsOfRank(String rank) {
        hand.removeIf(card -> card.getRank().equals(rank));
    }

    public List<Card> giveCards(String rank) {
        List<Card> cardsToGive = new ArrayList<>();
        hand.removeIf(card -> {
            if (card.getRank().equals(rank)) {
                cardsToGive.add(card);
                return true;
            }
            return false;
        });
        return cardsToGive;
    }

  
    public List<Card> getHand() {
        return hand;
    }

    public int getScore() {
        return score;
    }

 
    public void showHand() {
        System.out.print(this.name + "'s hand: ");
        for (Card card : hand) {
            System.out.print(card + " ");
        }
        System.out.println();
    }

  
    public abstract String selectCardRank();

    public abstract Player selectTargetPlayer(List<Player> players);
}
