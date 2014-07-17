package com.programapprentice.app;

import org.junit.Test;
//import com.programapprentice.app.ReverseWordsInAString;

import static junit.framework.Assert.assertEquals;

/**
 * @author rjiang
 * @date 7/17/14
 */
public class Test_ReverseWordsInAString {
    @Test
    public void testReverseWords() {
        String input = "the sky is blue";
        ReverseWordsInAString obj = new ReverseWordsInAString();
        String output = obj.reverseWords(input);
        assertEquals("blue is sky the", output);
    }

    @Test
    public void testReverseWords2() {
        String input = "   a   b ";
        ReverseWordsInAString obj = new ReverseWordsInAString();
        String output = obj.reverseWords(input);
        assertEquals("b a", output);
    }
}

