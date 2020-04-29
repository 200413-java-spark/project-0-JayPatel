package com.github.jaypatel.hangman;

import java.util.ArrayList;
import com.github.jaypatel.readwritehandling.FileParser;

public class Word {

    static int theWordLength;
    static String theWord;
    static char[] blanks;
    static int strikes = 0;
    static int strikesAllowed = 15;
    ArrayList<Character> mappedLetters = new ArrayList<Character>();
    ArrayList<Character> wrongLetters = new ArrayList<Character>();


    public Word() {
        FileParser fp = new FileParser();

    }

    public Word(String theWord) {
        this.theWord = theWord;
        this.theWordLength = theWord.length();
    }

    public Word(String theWord, int theWordLength) {
        this.theWord = theWord;
        this.theWordLength = theWordLength;
    }


    public static void createBlanks() {
        blanks = new char[theWord.length()];
        for (int i = 0; i < blanks.length; i++) {
            if (Character.isLetter(theWord.charAt(i)) || Character.isDigit(theWord.charAt(i))) {
                blanks[i] = '-';
            } else {
                blanks[i] = theWord.charAt(i);
                theWordLength--;
             }
         }
     }

     public void printBlanks() {
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
    public  String letterEntered(char letter) {
        if (!Character.isLetter(letter) && !Character.isDigit(letter)) {
            return ("Please enter one letter");
        } 
        for (int i = 0; i < theWord.length(); i++) {
            if (letter == blanks[i]) {
                return "You have already entered this letter";
            }
        }
        if (theWord.indexOf(Character.toLowerCase(letter)) == -1 && (theWord.indexOf(Character.toUpperCase(letter)) == -1)) {
            addWrongLetter(letter);
            strikes++;
            if (strikes >= strikesAllowed) {
                Hangman.continueGame = false;
                return ("Game Over, You Loose. The word was '" + theWord +  "'");
            } else {
                return "Wrong Guess, Enter next Letter";
            }
        } else {
            for (int i = 0; i < theWord.length(); i++) {
                if (theWord.charAt(i) == Character.toLowerCase(letter) || theWord.charAt(i) == Character.toUpperCase(letter)) {
                    mappedLetters.add(letter);
                    addCorrectLetter(letter, i);
                }
            }
            if (mappedLetters.size() == theWordLength) {
                Hangman.continueGame = false;
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

    public  void addWrongLetter(char letter) {
        wrongLetters.add(letter);
    }

    public  void addCorrectLetter(char letter) {
        int indexOfLetter = theWord.indexOf(letter);
        blanks[indexOfLetter] = letter;
    }

    public  void addCorrectLetter(char letter, int index) {
       
        blanks[index] = letter;
    }

    public  void displayWrongLetters() {
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

    
    public static String getWord() {
        return theWord;
    }

    
}


 