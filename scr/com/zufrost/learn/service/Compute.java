package com.zufrost.learn.service;

import java.util.*;

public class Compute {

    public static Double calculation(List<String> postfix) {
        Deque<Double> stack = new ArrayDeque<Double>();
        for (String x : postfix) {
            if (x.equals("sqrt")) stack.push(Math.sqrt(stack.pop()));
            else if (x.equals("cube")) {
                Double tmp = stack.pop();
                stack.push(tmp * tmp * tmp);
            }
            else if (x.equals("pow10")) stack.push(Math.pow(10, stack.pop()));
            else if (x.equals("+")) stack.push(stack.pop() + stack.pop());
            else if (x.equals("-")) {
                Double b = stack.pop(), a = stack.pop();
                stack.push(a - b);
            }
            else if (x.equals("*")) stack.push(stack.pop() * stack.pop());
            else if (x.equals("/")) {
                Double b = stack.pop(), a = stack.pop();
                stack.push(a / b);
            }
            else if (x.equals("u-")) stack.push(-stack.pop());
            else stack.push(Double.valueOf(x));
        }
        return stack.pop();
    }

    public static Double calculation(String postfix) {
        List<String> postfixList =  new ArrayList<String>(Arrays.asList(postfix.split("\\s")));

        return calculation(postfixList);
    }
}

//    public static Float computing(String string) {
//        // числа
//        LinkedList<Float> notationInputString = new LinkedList<Float>();
//        // операторы и notationInputString и notationInputStringWithOperators в порядке поступления
//        LinkedList<Character> notationInputStringWithOperators = new LinkedList<Character>();
//        for (int i = 0; i < string.length(); i++) { // парсим строку с выражением и вычисляем
//            char charFromString = string.charAt(i);
//            if (isDelimeter(charFromString))
//                continue;
//            if (charFromString == '(')
//                notationInputStringWithOperators.add('(');
//            else if (charFromString == ')') {
//                while (notationInputStringWithOperators.getLast() != '(')
//                    processOperator(notationInputString, notationInputStringWithOperators.removeLast());
//                notationInputStringWithOperators.removeLast();
//            } else if (isOperator(charFromString)) {
//                while (!notationInputStringWithOperators.isEmpty() && priority(notationInputStringWithOperators.getLast()) >= priority(charFromString))
//                    processOperator(notationInputString, notationInputStringWithOperators.removeLast());
//                notationInputStringWithOperators.add(charFromString);
//            } else {
//                String operand = "";
//                while (i < string.length() && (Character.isDigit(string.charAt(i)) || (string.charAt(i) == '.')))
//                    operand += string.charAt(i++);
//                --i;
//                notationInputString.add(Float.parseFloat(operand));
//            }
//        }
//        System.out.println("выводим содержимое notationInputStringWithOperators");
//        for (Character element: notationInputStringWithOperators) {
//            System.out.print(element + " ");
//        }
//        System.out.println();
//        while (!notationInputStringWithOperators.isEmpty())
//            processOperator(notationInputString, notationInputStringWithOperators.removeLast());
//        return notationInputString.get(0);  // возврат результата
//    }
//
//
//    public static List<String> transformToReversePolishNotation(String infix) {
//        List<String> postfix = new ArrayList<String>();
//        Deque<String> stack = new ArrayDeque<String>();
//        StringTokenizer tokenizer = new StringTokenizer(infix, delimiters, true);
//        String prev = "";
//        String curr = "";
//        while (tokenizer.hasMoreTokens()) {
//            curr = tokenizer.nextToken();
//            if (!tokenizer.hasMoreTokens() && isOperator(curr)) {
//                System.out.println("Некорректное выражение.");
//                flag = false;
//                return postfix;
//            }
//            if (curr.equals(" ")) continue;
//            if (isFunction(curr)) stack.push(curr);
//            else if (isDelimiter(curr)) {
//                if (curr.equals("(")) stack.push(curr);
//                else if (curr.equals(")")) {
//                    while (!stack.peek().equals("(")) {
//                        postfix.add(stack.pop());
//                        if (stack.isEmpty()) {
//                            System.out.println("Скобки не согласованы.");
//                            flag = false;
//                            return postfix;
//                        }
//                    }
//                    stack.pop();
//                    if (!stack.isEmpty() && isFunction(stack.peek())) {
//                        postfix.add(stack.pop());
//                    }
//                }
//                else {
//                    if (curr.equals("-") && (prev.equals("") || (isDelimiter(prev)  && !prev.equals(")")))) {
//                        // унарный минус
//                        curr = "u-";
//                    }
//                    else {
//                        while (!stack.isEmpty() && (priority(curr) <= priority(stack.peek()))) {
//                            postfix.add(stack.pop());
//                        }
//
//                    }
//                    stack.push(curr);
//                }
//
//            }
//
//            else {
//                postfix.add(curr);
//            }
//            prev = curr;
//        }
//
//        while (!stack.isEmpty()) {
//            if (isOperator(stack.peek())) postfix.add(stack.pop());
//            else {
//                System.out.println("Скобки не согласованы.");
//                flag = false;
//                return postfix;
//            }
//        }
//        return postfix;
//    }
//
//    static boolean isDelimeter(char c) { // тру если пробел
//        return c == ' ';
//    }
//
//    static boolean isOperator(char c) { // возвращяем тру если один из символов ниже
//        return c == '+' || c == '-' || c == '*' || c == '/' || c == '%';
//    }
//
//    static int priority(char op) {
//        switch (op) { // при + или - возврат 1, при * / % 2 иначе -1
//            case '+':
//            case '-':
//                return 1;
//            case '*':
//            case '/':
//            case '%':
//                return 2;
//            default:
//                return -1;
//        }
//    }
//
//    static void processOperator(LinkedList<Float> notationInputString, char lastCharFromNotationInputStringWithOperators) {
//        Float operatorOne = notationInputString.removeLast(); // выдёргиваем из упорядоченного листа последний элемент
//        Float operatorTwo = notationInputString.removeLast(); // также
//        // выполняем действие между operatorOne и operatorTwo в зависимости от оператора в кейсе и результат в notationInputString
//        switch (lastCharFromNotationInputStringWithOperators) {
//            case '+':
//                notationInputString.add(operatorTwo + operatorOne);
//                break;
//            case '-':
//                notationInputString.add(operatorTwo - operatorOne);
//                break;
//            case '*':
//                notationInputString.add(operatorTwo * operatorOne);
//                break;
//            case '/':
//                notationInputString.add(operatorTwo / operatorOne);
//                break;
//            case '%':
//                notationInputString.add(operatorTwo % operatorOne);
//                break;
//        }
//    }
//}
