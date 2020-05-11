package com.zufrost.learn.service;

import java.util.*;

public class ReversePolishNotationParser {

    private static String operators = "+-*/";
    private static String delimiters = "() " + operators;

    private static boolean isDelimiter(String token) {
        if (token.length() != 1) return false;
        for (int i = 0; i < delimiters.length(); i++) {
            if (token.charAt(0) == delimiters.charAt(i)) return true;
        }
        return false;
    }

    private static boolean isOperator(String token) {
        if (token.equals("u-")) return true;
        for (int i = 0; i < operators.length(); i++) {
            if (token.charAt(0) == operators.charAt(i)) return true;
        }
        return false;
    }

    private static int priority(String token) {
        if (token.equals("(")) return 1;
        if (token.equals("+") || token.equals("-")) return 2;
        if (token.equals("*") || token.equals("/")) return 3;
        return 4;
    }

    public static List<String> parseToList(String infix) {
        List<String> outputStringList = new ArrayList<>();
        Deque<String> stack = new ArrayDeque<>();
        StringTokenizer tokenizer = new StringTokenizer(infix, delimiters, true);
        String previousToken = "";
        String currentToken = "";
        while (tokenizer.hasMoreTokens()) {
            currentToken = tokenizer.nextToken();
            if (!tokenizer.hasMoreTokens() && isOperator(currentToken)) {
                throw new IllegalArgumentException("Некорректное выражение.");
            }
            if (currentToken.equals(" ")) continue;
            else if (isDelimiter(currentToken)) {
                if (currentToken.equals("(")) stack.push(currentToken);
                else if (currentToken.equals(")")) {
                    while (!stack.peek().equals("(")) {
                        outputStringList.add(stack.pop());
                        if (stack.isEmpty()) {
                            throw new IllegalArgumentException("Скобки не согласованы.");
                        }
                    }
                    stack.pop();
                } else {
                    if (currentToken.equals("-") && (previousToken.equals("") || (isDelimiter(previousToken) && !previousToken.equals(")")))) {
                        // унарный минус
                        currentToken = "u-";
                    } else {
                        while (!stack.isEmpty() && (priority(currentToken) <= priority(stack.peek()))) {
                            outputStringList.add(stack.pop());
                        }
                    }
                    stack.push(currentToken);
                }
            } else {
                outputStringList.add(currentToken);
            }
            previousToken = currentToken;
        }

        while (!stack.isEmpty()) {
            if (isOperator(stack.peek())) outputStringList.add(stack.pop());
            else {
                throw new IllegalArgumentException("Скобки не согласованы.");
            }
        }
        return outputStringList;
    }

    public static String parseToString(String string) {
        List<String> stringList = parseToList(string);
        String expression = "";
        for (String element : stringList) {
            expression = expression + element + " ";
        }
        return expression;

    }
}
