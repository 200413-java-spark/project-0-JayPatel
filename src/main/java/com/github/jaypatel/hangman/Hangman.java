package com.github.jaypatel.hangman;

import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;
/**
 * A game of Hangman
 * @author Jay Patel
 * @version 0.1.1
 */

public class Hangman {
    static int strikes = 0;
    static String theWord = "Mouse";
    static int counter = 0;
    static boolean continueGame = true;
    static Map<String, Integer> mappedLetters = new HashMap<String, Integer>();

    public static void main( String[] args) {

        startGame();

    }

    /**
     * Starts the game of Hangman.
     */
    public static void startGame() {
        
        System.out.println("Hello! Lets play a game of Hangman");
        System.out.println("The length of the word is " + theWord.length());
        System.out.println("Enter the first letter");

        while (continueGame) {
            Scanner scan = new Scanner(System.in);
            String letter = scan.nextLine();
            String msg = letterEntered(letter);
            System.out.println("You entered " + letter);
            System.out.println(msg);
        }
    }



/**
 * This method takes in the letter that is entered either verifys if its correct or not correct 
 * returns accordingly
 * @param: The letter that is entered 
 * @return: A string message that says correct/incorrect guess
 */


    public static String letterEntered(String letter) {
        counter++;
        if (theWord.indexOf(letter) < 0) {
            strikes++;
            if (strikes >= 3) {
                continueGame = false;
                return "Game Over, You Loose";
            } else {
                return "Wrong Guess, Enter next Letter";
            }
        } else {
            mappedLetters.put(letter, counter);
            if (mappedLetters.size() == theWord.length()) {
                continueGame = false;
                return "You Win!";
            } else  {
                return "Correct guess, Enter next Letter";
            }
        }
    }
}