/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * The class that models your game. You should create a more specific child of this class and instantiate the methods
 * given.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @author tech titans 
 */
public abstract class Game {

    private final String name; // the title of the game
    private ArrayList<Player> players; // the players of the game

    public Game(String name) {
        this.name = name;
        players = new ArrayList<>();
    }

 
    public String getName() {
        return name;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

 
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public abstract void play();
    public void start() {
        
    }

    public void end() {
        
    }

 
    public abstract void declareWinner();
}
