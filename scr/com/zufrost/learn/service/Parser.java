package com.zufrost.learn.service;

import java.util.LinkedList;

public class Parser {
    public static String parser(String string) {

        return string + " no edit";
    }

    static boolean isDelimeter(char c) { // тру если пробел
        return c == ' ';
    }

    static boolean isOperator(char c) { // возвращяем тру если один из символов ниже
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '%';
    }

    static int priority(char op) {
        switch (op) { // при + или - возврат 1, при * / % 2 иначе -1
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
            case '%':
                return 2;
            default:
                return -1;
        }
    }

    static void processOperator(LinkedList<Float> notationInputString, char lastCharFromNotationInputStringWithOperators) {
        Float operatorOne = notationInputString.removeLast(); // выдёргиваем из упорядоченного листа последний элемент
        Float operatorTwo = notationInputString.removeLast(); // также
        // выполняем действие между operatorOne и operatorTwo в зависимости от оператора в кейсе и результат в notationInputString
        switch (lastCharFromNotationInputStringWithOperators) {
            case '+':
                notationInputString.add(operatorTwo + operatorOne);
                break;
            case '-':
                notationInputString.add(operatorTwo - operatorOne);
                break;
            case '*':
                notationInputString.add(operatorTwo * operatorOne);
                break;
            case '/':
                notationInputString.add(operatorTwo / operatorOne);
                break;
            case '%':
                notationInputString.add(operatorTwo % operatorOne);
                break;
        }
    }

    public static Float eval(String string) {
        // числа
        LinkedList<Float> notationInputString = new LinkedList<Float>();
        // операторы и notationInputString и notationInputStringWithOperators в порядке поступления
        LinkedList<Character> notationInputStringWithOperators = new LinkedList<Character>();
        for (int i = 0; i < string.length(); i++) { // парсим строку с выражением и вычисляем
            char charFromString = string.charAt(i);
            if (isDelimeter(charFromString))
                continue;
            if (charFromString == '(')
                notationInputStringWithOperators.add('(');
            else if (charFromString == ')') {
                while (notationInputStringWithOperators.getLast() != '(')
                    processOperator(notationInputString, notationInputStringWithOperators.removeLast());
                notationInputStringWithOperators.removeLast();
            } else if (isOperator(charFromString)) {
                while (!notationInputStringWithOperators.isEmpty() && priority(notationInputStringWithOperators.getLast()) >= priority(charFromString))
                    processOperator(notationInputString, notationInputStringWithOperators.removeLast());
                notationInputStringWithOperators.add(charFromString);
            } else {
                String operand = "";
                while (i < string.length() && (Character.isDigit(string.charAt(i)) || (string.charAt(i) == '.')))
                    operand += string.charAt(i++);
                --i;
                notationInputString.add(Float.parseFloat(operand));
            }
        }
        while (!notationInputStringWithOperators.isEmpty())
            processOperator(notationInputString, notationInputStringWithOperators.removeLast());
        return notationInputString.get(0);  // возврат результата
    }

}
