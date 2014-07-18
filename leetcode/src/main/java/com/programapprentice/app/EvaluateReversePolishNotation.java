package com.programapprentice.app;

/**
 * @author rjiang
 * @date 7/18/14
 */

import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.

 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.

 * Some examples:
 ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6*/


public class EvaluateReversePolishNotation {
    public boolean isOperator(String input) {
        if (input.equals("+") || input.equals("-") || input.equals("/") || input.equals("*")) {
            return true;
        }
        else
            return false;
    }

    public int operate(int left, int right, String operator) {
        switch(operator.charAt(0)) {
            case '+':
                return left + right;
            case '-':
                return left - right;
            case '*':
                return left * right;
            case '/':
                return left / right;
            default:
                return 0;
        }
    }

    public int evalRPN(String[] tokens) {
        if (tokens == null)
            return 0;
        if (tokens.length == 1) {
            if(!isOperator(tokens[0])) {
                return Integer.parseInt(tokens[0]);
            }
        }
        Stack<Integer> stack = new Stack<Integer>();
        for(String token : tokens) {
            if(isOperator(token)) {
                int right = stack.pop();
                int left = stack.pop();
                stack.push(operate(left, right, token));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

}
