package ca.sheridancollege.project;

import java.util.List;
import java.util.Random;

/**
 * Class representing a computer player.
 * 
 * @author tech titans
 */
public class ComputerPlayer extends Player {
    public ComputerPlayer(String name) {
        super(name);
    }

    @Override
    public void requestCard(Player targetPlayer, String rank, Deck deck) {
        if (targetPlayer == null) {
            System.out.println("Invalid player selected.");
            return;
        }
        
        List<Card> cardsToTransfer = targetPlayer.giveCards(rank);
        if (cardsToTransfer.isEmpty()) {
            System.out.println("Go Fish!");
            draw(deck);
        } else {
            hand.addAll(cardsToTransfer);
        }
        hasSetofCards();
    }

    @Override
    public String selectCardRank() {
        Random rand = new Random();
        int index = rand.nextInt(hand.size());
        return hand.get(index).getRank();
    }

    @Override
    public Player selectTargetPlayer(List<Player> players) {
        Random rand = new Random();
        int index;
        do {
            index = rand.nextInt(players.size());
        } while (players.get(index).getName().equals(this.getName()));
        return players.get(index);
    }

    @Override
    public void play() {
    }
}
