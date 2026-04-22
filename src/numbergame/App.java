package numbergame;

import java.util.ArrayList;
import java.util.Scanner;

import numberGame;

// Task 0: Make the NumberGuessGame work in Game.java
// Optional: 
// Task 1: Get getNumGuesses() to work correctly for each Game, and call getBestGame() here in App.java

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to the Number Guess Game!");
        // See Game for pseudocode you need to fill out
        // Create a new Game that sets a number within the user's specified number range
        ArrayList<numberGame> games = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("To play a game, press 'y'. If you want to stop playing, type anything other than 'y'.");
        while (sc.hasNext() && sc.next().equals("y")) {
            numberGame g = new numberGame(1, 100);
            g.play();
            games.add(g);
            getBestGame(games);
            System.out.println("press 'y' to play another game.");
        }

    }

    public static void getBestGame(ArrayList<numberGame> games) {
        // best game
        int minGame = 0;
        for (numberGame g : games) {
            if (g.getNumGuesses() < minGame) {
                minGame = g.getNumGuesses();
            }
        }
        System.out.println("min game is: " + minGame);
    }
}
