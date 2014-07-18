package com.programapprentice.app;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * @author rjiang
 * @date 7/18/14
 */
public class Test_EvaluateReversePolishNotation {
    @Test
    public void testevalRPN() {
        String[] input1 = {"2", "1", "+", "3", "*"};
        EvaluateReversePolishNotation obj = new EvaluateReversePolishNotation();
        int output = obj.evalRPN(input1);
        assertEquals(9, output);

        String[] input2 = {"4", "13", "5", "/", "+"};
        output = obj.evalRPN(input2);
        assertEquals(6, output);
    }
}
