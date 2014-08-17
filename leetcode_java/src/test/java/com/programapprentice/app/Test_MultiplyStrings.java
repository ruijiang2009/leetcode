package com.programapprentice.app;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: ruijiang
 * Date: 8/16/14
 * Time: 10:31 PM
 */
public class Test_MultiplyStrings {
    MultiplyStrings obj = new MultiplyStrings();

    @Test
    public void test1() {
        String num1 = "123";
        String num2 = "2";
        String output = obj.multiply(num1, num2);
        String expected = "246";
        assertEquals(expected, output);
    }

    @Test
    public void test2() {
        String num1 = "123";
        String num2 = "9";
        String output = obj.multiply(num1, num2);
        String expected = "1107";
        assertEquals(expected, output);
    }

    @Test
    public void test3() {
        String num1 = "123";
        String num2 = "456";
        String output = obj.multiply(num1, num2);
        String expected = "56088";
        assertEquals(expected, output);
    }

    @Test
         public void test4() {
        String num1 = "123";
        String num2 = "56";
        String output = obj.multiply(num1, num2);
        String expected = "6888";
        assertEquals(expected, output);
    }

    @Test
    public void test5() {
        String num1 = "123";
        String num2 = "400";
        String output = obj.multiply(num1, num2);
        String expected = "49200";
        assertEquals(expected, output);
    }

}
