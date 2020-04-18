package com.github.jaypatel.hangman;

import java.util.Scanner;
import java.util.ArrayList;
/**
 * A game of Hangman
 * @author Jay Patel
 * @version 0.1.1
 */

public class Hangman {
    static int strikes = 0;
    static int strikesAllowed = 15;
    static String theWord = "glassess";
    static int counter = 0;
    static boolean continueGame = true;
    static ArrayList<Character> mappedLetters = new ArrayList<Character>();
    static char[] blanks;
    static int wrongGuessesCounter = 0;
    static ArrayList<Character> wrongLetters = new ArrayList<Character>();
    static Scanner scan = new Scanner(System.in);

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
        System.out.println("The length of the word is " + theWord.length());
        createBlanks();
        printBlanks();

        System.out.println("Enter the first letter");

        while (continueGame) {
            char letter = scan.next().charAt(0);
            letter = Character.toLowerCase(letter);
            System.out.println("You entered " + letter);

      
            String msg = letterEntered(letter);


            System.out.println(msg);
            printBlanks();
            displayWrongLetters();

        }
    }

    public static void createBlanks() {
        blanks = new char[theWord.length()];
        for (int i = 0; i < blanks.length; i++) {
            blanks[i] = '-';
        }
    }

    public static void printBlanks() {
        for (int i = 0; i < blanks.length; i++) {
            System.out.print(blanks[i]);
        }
        System.out.println();
    }

    /**
     * This method takes in the letter that is entered either verifys if its correct
     * or not correct returns accordingly
     * 
     * @param: The letter that is entered
     * @return: A string message that says correct/incorrect guess
     */
    public static String letterEntered(char letter) {
        for (int i = 0; i < theWord.length(); i++) {
            if (letter == blanks[i]) {
                return "You have already entered this letter";

            }
        }
        counter++;
        if (letter == 0) {
            counter--;
            return ("Please enter one character");
        }
        if (theWord.indexOf(letter) == -1) {
            addWrongLetter(letter);
            strikes++;
            if (strikes >= strikesAllowed) {
                continueGame = false;
                return ("Game Over, You Loose. The word was " + theWord);
            } else {
                return "Wrong Guess, Enter next Letter";
            }
        } else {
            for (int i = 0; i < theWord.length(); i++) {
                if (theWord.charAt(i) == letter) {
                    mappedLetters.add(letter);
                    addCorrectLetter(letter, i);

                }
            }


            if (mappedLetters.size() == theWord.length()) {
                continueGame = false;
                return "You Win!";
            } else {
                for (int i = 0; i < theWord.length(); i++) {
                    if (theWord.charAt(i) == letter) {
                        addCorrectLetter(letter, i);
                    }
                }
                
                return "Correct guess, Enter next Letter.";
            }

        }

    }

    public static void addWrongLetter(char letter) {
        wrongLetters.add(letter);
        wrongGuessesCounter++;


    }

    public static void displayWrongLetters() {
        if (wrongLetters.size() == 0) {
            return;
        } else {
            System.out.print("Wrong Guesses: ");

            for(char i:wrongLetters) {
                System.out.print(i); 
                System.out.print(" ");
            }
            System.out.println();
        }
     
    }



    public static void addCorrectLetter(char letter) {
        int indexOfLetter = theWord.indexOf(letter);
        blanks[indexOfLetter] = letter;
    }

    public static void addCorrectLetter(char letter, int index) {
       
        blanks[index] = letter;
    }





}