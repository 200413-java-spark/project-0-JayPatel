package com.github.jaypatel.hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class Word {

     int theWordLength;
     String theWord;
     char[] blanks;
     int counter = 0;
     static int strikes = 0;
     static int strikesAllowed = 15;
      ArrayList<Character> mappedLetters = new ArrayList<Character>();
      ArrayList<Character> wrongLetters = new ArrayList<Character>();



     public Word() {
         File file = new File(
                 "/Users/Jay/OneDrive/Desktop/Java/Revature/project-0/src/main/java/com/github/jaypatel/hangman/listofwords.txt");
         Random r = new Random();
         int n = 0;
         try {
             for (Scanner scan = new Scanner(file); scan.hasNext();) {
                 n++;
                 String line = scan.nextLine();
                 if (r.nextInt(n) == 0) {
                     theWord = line;
                 }
             }
         } catch (FileNotFoundException e) {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         }
         this.theWordLength = theWord.length();
         createBlanks();
     }


     public void createBlanks() {
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

        counter++;
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
}


 