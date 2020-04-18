package com.github.jaypatel.hangman;

import java.util.Scanner;
/**
 * A game of Hangman
 * @author Jay Patel
 * @version 0.1.1
 */

public class Hangman {

    static boolean continueGame = true;
    static Scanner scan = new Scanner(System.in);
    static Word word = new Word();


    public static void main(String[] args) {

        System.out.println("Hello! Do you want to play a game of Hangman?");
        System.out.println("Press 'Y' for yes and 'N' for no");
        boolean temp = true;
        while (temp) {
            char answer = scan.next().charAt(0);
            answer = Character.toLowerCase(answer);
            if (answer == 'y') {
                temp = false;
                startGame();
            } 
            if (answer == 'n') {
                temp = false;
                System.out.println("Thank You");
            }
        }
    } 

    /**
     * Starts the game of Hangman.
     */
    public static void startGame() {

        System.out.println("Lets play a game of Hangman");

        System.out.println("The length of the word is " + word.theWordLength);
        word.printBlanks();
        System.out.println("Enter the first letter");
        while (continueGame) {
            char letter = scan.next().charAt(0);
            System.out.println("You entered " + letter);
            String msg = word.letterEntered(letter);
            System.out.println(msg);

            word.printBlanks();
            Word.displayWrongLetters();
            System.out.println("You have " + (Word.strikesAllowed - Word.strikes) + "/" + Word.strikesAllowed + " wrong guesses left" );
        }
    }




}