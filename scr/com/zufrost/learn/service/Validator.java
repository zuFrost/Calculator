package com.zufrost.learn.service;

public class Validator {
    public static boolean checkStringExpression(String stringExpression) {
        //проверка на пустую стоку
        if (stringExpression.equals("")) {
            throw new IllegalArgumentException("You input empty arithmetical expression");
        }
        if (stringExpression.contains(",")) {
            throw new IllegalArgumentException("Используйте '.' для разделения целой и дробной части числа");
        }
        // проверка на правильность ввода
        if (!stringExpression.matches("[\\d0-9+\\-*\\/\\.\\s()]*")) {
            throw new IllegalArgumentException("Строка содержит запрещенные символы. " +
                    "\nИспользуйте только цифры 0-9 разделитель дроби '.' и знаки математических операций '+' '-' '*' '/' ");
        }
        //проверка на лидирующий '+' '*' '/' '.'
        if (stringExpression.startsWith("+") ||
                stringExpression.startsWith("*") ||
                stringExpression.startsWith("/"))
        {
            throw new IllegalArgumentException("Выражение не может начинаться с '+' '*' '/'");
        }
        //проверка на финальный '-' '+' '*' '/'
        if (stringExpression.endsWith("+") ||
                stringExpression.endsWith("*") ||
                stringExpression.endsWith("/") ||
                stringExpression.endsWith("-")) {
            throw new IllegalArgumentException("Выражение не может заканчиваться на  '+' '*' '/' ");
        }
        //Поверка на дублирующиеся символы операций, введение некорректного выражения вида 4++2 и дублирующуюся точку
        if (stringExpression.matches(".*([\\+\\-\\*\\/\\.][\\+\\-\\*\\/\\.]+).*")) {
            throw new IllegalArgumentException("Не допускается введение некорректного выражения вида 4++2. " +
                    "\nТ.е. не может быть дублирующихся символов операций или двойного разделителя дроби вида 4..2 " +
                    "\nСочетания вида .+ или +. так же не допускаются");
        }
        return true;
    }
}
