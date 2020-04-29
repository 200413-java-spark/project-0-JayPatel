package com.github.jaypatel.hangman;

import java.util.Scanner;

import com.github.jaypatel.readwritehandling.MyDatabase;
/**
 * A game of Hangman
 * @author Jay Patel
 * @version 0.1.1
 */

public class Hangman {

    static  boolean continueGame = true;

    static Scanner scan = new Scanner(System.in);


    public static void main(String[] args) {

        mainMenu();
        MyDatabase.updateTable();

 
    } 

    // public static int getGameStart() {
    //     if (gameStart == true) {
    //         return 1;
    //     } else {
    //         return 0;
    //     }
    // }

    // public static int getGameWon() {
    //     if (gameWon == true) {
    //         return 1;
    //     } else {
    //         return 0;
    //     }
    // }




    public static void mainMenu() {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("Hello! Welcome to Hangman!");
        System.out.println("Please select one of the following options.");
        System.out.println("1. Start Game");
        System.out.println("3. Quit Game");

        boolean temp = true;
        while (temp) {
            int answer = scan.nextInt();
            if (answer == 1) {
                temp = false;
                startGame();
            } 
            // if (answer == 2) {
            //     showLeaderboard();
            // }
           else if (answer == 3) {
                temp = false;
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println("Game Over, Thank You");
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
            // } else {
            //     System.out.println("Not a valid input, please enter again.");
            }
        }
    }


    // public static void createPlayer() {
    //     System.out.println("Please enter your name");
    //     String name = scan.nextLine();
    //     Player p = new Player(name);

    // }


    /**
     * Starts the game of Hangman.
     */
    public static void startGame() {

  
    //  Word word = new Word("hello");
        Word word = new Word();

        System.out.println("Lets play a game of Hangman");

        System.out.println("The length of the word is " + Word.theWordLength);
        word.printBlanks();
        System.out.println("Enter the first letter");
        while (continueGame) {
            char letter = scan.next().charAt(0);
            System.out.println("You entered " + letter);
            String msg = word.letterEntered(letter);
            System.out.println(msg);

            word.printBlanks();
            word.displayWrongLetters();
            System.out.println("You have " + (Word.strikesAllowed - Word.strikes) + "/" + Word.strikesAllowed + " wrong guesses left" );
        }
    }




}