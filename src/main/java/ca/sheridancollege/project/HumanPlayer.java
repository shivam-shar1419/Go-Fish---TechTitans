package ca.sheridancollege.project;

import java.util.List;
import java.util.Scanner;

/**
 * Class representing a human player.
 * 
 * @author tech titans
 */
public class HumanPlayer extends Player {
    public HumanPlayer(String name) {
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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the rank you want to request: ");
        return scanner.nextLine();
    }

    @Override
    public Player selectTargetPlayer(List<Player> players) {
        Scanner scanner = new Scanner(System.in);
        Player targetPlayer = null;

        while (targetPlayer == null) {
            System.out.println("Enter the exact name of the player you want to request from: ");
            for (Player player : players) {
                if (!player.getName().equals(this.getName())) {
                    System.out.println("- " + player.getName());
                }
            }

            String playerName = scanner.nextLine();

            for (Player player : players) {
                if (player.getName().equalsIgnoreCase(playerName) && !player.getName().equals(this.getName())) {
                    targetPlayer = player;
                    break;
                }
            }

            if (targetPlayer == null) {
                System.out.println("Player not found. Please select a valid player.");
            }
        }

        return targetPlayer;
    }

    @Override
    public void play() {
        
    }
}
