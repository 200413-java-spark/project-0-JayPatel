package com.github.jaypatel.hangman;

import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

public class HangmanTest {

    Word word;

    @Before
    public void init() {
        word = new Word("hello");

    }


    @Test
    public void whenwrongletteredEntered() {
        assertSame(word.letterEntered('i'), "Wrong Guess, Enter next Letter" );
        assertSame(word.letterEntered('8'), "Wrong Guess, Enter next Letter" );
        assertSame(word.letterEntered('!'), "Wrong Guess, Enter next Letter" );

    }


    @Test
    public void whencorrectletterEntered() {
		assertSame(word.letterEntered('e'), "Correct guess, Enter next Letter.");

    }

    



}