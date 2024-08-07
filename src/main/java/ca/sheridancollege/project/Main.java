/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Main class to start the Go Fish game.
 * 
 * @author tech titans
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numPlayers = 0;

        while (numPlayers <= 0) {
            try {
                System.out.print("Enter the number of players: ");
                numPlayers = scanner.nextInt();
                scanner.nextLine(); 

                if (numPlayers <= 0) {
                    System.out.println("Please enter a positive number.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine();
            }
        }

        ArrayList<Player> players = new ArrayList<>();

        for (int i = 1; i <= numPlayers; i++) {
            System.out.print("Is player " + i + " a human or computer? (h/c): ");
            String playerType = scanner.nextLine();
            
            System.out.print("Enter the name of Player " + i + ": ");
            String playerName = scanner.nextLine();
            
            Player player;
            if (playerType.equalsIgnoreCase("h")) {
                player = new HumanPlayer(playerName);
            } else {
                player = new ComputerPlayer(playerName);
            }
            players.add(player);
        }

        
        GoFishGame game = new GoFishGame("Go Fish");
        game.setPlayers(players);

       
        game.play();
    }
}
