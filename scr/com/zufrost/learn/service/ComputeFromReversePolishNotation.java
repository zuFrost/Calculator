package com.zufrost.learn.service;

import java.util.*;

public class ComputeFromReversePolishNotation {

    public static Double calculate(List<String> outputStringList) {
        Deque<Double> stack = new ArrayDeque<>();
        for (String element : outputStringList) {
            if (element.equals("+")) stack.push(stack.pop() + stack.pop());
            else if (element.equals("-")) {
                Double numberTwo = stack.pop(), numberOne = stack.pop();
                stack.push(numberOne - numberTwo);
            } else if (element.equals("*")) stack.push(stack.pop() * stack.pop());
            else if (element.equals("/")) {
                Double numberTwo = stack.pop(), numberOne = stack.pop();
                if (numberTwo == 0) {
                    throw new ArithmeticException("деление на ноль");
                }
                stack.push(numberOne / numberTwo);
            } else if (element.equals("u-")) stack.push(-stack.pop());
            else stack.push(Double.valueOf(element));
        }
        return stack.pop();
    }

    public static Double calculate(String outputString) {
        ArrayList<String> outputStringList = new ArrayList<>(Arrays.asList(outputString.split(" ")));
        return calculate(outputStringList);
    }
}

