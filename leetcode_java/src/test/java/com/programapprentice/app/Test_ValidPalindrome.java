package com.programapprentice.app;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: ruijiang
 * Date: 8/2/14
 * Time: 6:39 PM
 */
public class Test_ValidPalindrome {
    ValidPalindrome obj = new ValidPalindrome();

    @Test
    public void test1() {
        String input = "A man, a plan, a canal: Panama";
        boolean expected = true;
        boolean output = obj.isPalindrome(input);
        assertEquals(expected, output);
    }

    @Test
    public void test2() {
        String input = "race a car";
        boolean expected = false;
        boolean output = obj.isPalindrome(input);
        assertEquals(expected, output);
    }

    @Test
    public void test3() {
        String input = "  * & ^";
        boolean expected = true;
        boolean output = obj.isPalindrome(input);
        assertEquals(expected, output);
    }

    @Test
    public void test4() {
        String input = "(())&^%%&a*";
        boolean expected = true;
        boolean output = obj.isPalindrome(input);
        assertEquals(expected, output);
    }
}
