package numbergame;

import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.util.HashSet;
import Game.Game;
public class numberGame implements Game {
    int guesses;
    int highscore = 0;
    int numToGuess;
    int currentguess;
    static Scanner sc = new Scanner(System.in);
    static HashSet<Integer> listofguesses;
    boolean notcorrect = false;
    numberGame(int low, int high) {
        guesses = 0;
        System.out.println("I'm thinking of a number + " + low + " to " + high);
        Random r = new Random();
        numToGuess = r.nextInt(low,high);
        listofguesses = new HashSet<>();

    }

    public void play() {
        System.out.println("begin play!");
        
        while (!notcorrect)  {
            currentguess = getGuess();
            listofguesses.add(currentguess);
            System.out.println("You guessed " + currentguess);
            if (currentguess > numToGuess) {
                System.out.println("The number is less than what you guessed!");
            } else if (currentguess < numToGuess) {
                System.out.println("The number is more than what you guessed!");
                
            } else {
                notcorrect = true;
            }
        }

        System.out.println("Yay! You guessed correctly!");

        System.out.println("You ended with " + getScore() + ".");
        
        System.out.println("Done playing!");
        if (getNumGuesses() > highscore) {
            highscore = getNumGuesses();
        }
    }

    int getGuess() {
        int answer;
        if (sc.hasNextInt()) {
            answer = sc.nextInt();
            if (listofguesses.contains(answer)) {
                System.out.println("You have already guessed this! Enter a number you have not input yet.");
                return getGuess();
            } else {
                guesses ++;
                return answer;
            }
            
        } else{
            sc.next();
            System.out.println("Invalid input. Please input an integer again.");
            return getGuess();
        }
    }
    public void writeHighScore(File f) {
        System.out.println("Your highscore is:" + highscore);
    }
    public int getNumGuesses() {
        return guesses;
    }
    public String getScore() {
        return Integer.toString(guesses);
    }
    
    public String getGameName() {
        return "Guess Number Game";
    }
    

}
