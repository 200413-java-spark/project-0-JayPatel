package com.github.jaypatel.readwritehandling;

import java.util.Random;
import java.util.Scanner;
import com.github.jaypatel.hangman.Word;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public class FileParser {

    public  String theWord;

     public  FileParser() {
         File file = new File(
                 "/Users/Jay/OneDrive/Desktop/Java/Revature/project-0/src/main/java/com/github/jaypatel/readwritehandling/listofwords.txt");
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
        
         Word newword = new Word(theWord, theWord.length());
         Word.createBlanks();
         
     }


}