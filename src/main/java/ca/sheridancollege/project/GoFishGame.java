package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class representing a Go Fish game.
 * 
 * @author tech titans
 */
public class GoFishGame extends Game {
    private Deck deck;
    private int currentPlayerIndex;
    private boolean isStarted;

    public GoFishGame(String name) {
        super(name);
        this.deck = new Deck();
        this.currentPlayerIndex = 0;
        this.isStarted = false; 
    }

    @Override
    public void play() {
        start();
        while (!isGameOver()) {
            playTurn();
        }
        end();
        declareWinner();
    }

    @Override
    public void start() {
        isStarted = true; 
        deck.shuffle();
        for (Player player : getPlayers()) {
            for (int i = 0; i < 5; i++) {
                player.draw(deck);
            }
        }
        showHumanHand();
    }

    public boolean isStarted() {
        return isStarted;
    }

    public void playTurn() {
        Player currentPlayer = getPlayers().get(currentPlayerIndex);
        System.out.println(currentPlayer.getName() + "'s turn.");

        if (currentPlayer instanceof HumanPlayer) {
            showHumanHand();
        }

        String requestedRank = currentPlayer.selectCardRank();
        Player targetPlayer = currentPlayer.selectTargetPlayer(getPlayers());

        currentPlayer.requestCard(targetPlayer, requestedRank, deck);

        if (currentPlayer.hasSetofCards()) {
            System.out.println(currentPlayer.getName() + " has formed a book!");
        }

        displayScores();

        currentPlayerIndex = (currentPlayerIndex + 1) % getPlayers().size();
    }

    public void displayScores() {
        System.out.println("Current Scores:");
        for (Player player : getPlayers()) {
            System.out.println(player.getName() + ": " + player.getScore());
        }
    }

    public void showHumanHand() {
        for (Player player : getPlayers()) {
            if (player instanceof HumanPlayer) {
                player.showHand();
                break;
            }
        }
    }

    public void goFish(Player player) {
        Card drawnCard = deck.drawCard();
        if (drawnCard != null) {
            player.getHand().add(drawnCard);
        } else {
            System.out.println("The draw pile is empty. Skipping turn.");
        }
    }

    @Override
    public void end() {
        System.out.println("Game over.");
    }

    @Override
    public void declareWinner() {
        Player winner = null;
        int highestScore = 0;
        boolean isTie = false;

        for (Player player : getPlayers()) {
            if (player.getScore() > highestScore) {
                highestScore = player.getScore();
                winner = player;
                isTie = false;
            } else if (player.getScore() == highestScore) {
                isTie = true;
            }
        }

        if (isTie) {
            System.out.println("The game is a tie!");
        } else if (winner != null) {
            System.out.println("The winner is " + winner.getName() + " with " + highestScore + " books.");
        }
    }

    public boolean isGameOver() {
        if (deck.isEmpty()) {
            for (Player player : getPlayers()) {
                if (!player.getHand().isEmpty()) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}