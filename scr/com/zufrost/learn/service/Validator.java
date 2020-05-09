package com.zufrost.learn.service;

public class Validator implements IValidator {
    @Override
    public boolean checkStringExpression(String stringExpression){
        System.out.println("Validator | получил на обработку строку " + stringExpression);

        //проверка на пустую стоку
        if (stringExpression.equals("")) {
            throw new IllegalArgumentException("You input empty arithmetical expression");
        }
        // проверка на ()
        if (stringExpression.contains("(") || stringExpression.contains(")")) {
            throw new IllegalArgumentException("Данная версия программы не поддерживает скобки \"()\"");
        }
        // проверка на правильность ввода
        if (!stringExpression.matches("[\\d0-9+\\-*\\/.]")) {
            throw new IllegalArgumentException("Строка содержит запрещенные символы. Используйте только цифры 0-9 разделитель дроби '.' " +
                    "и знаки математических операций '+' '-' '*' '/' ");
//            System.out.println("Строка содержит запрещенные символы. Используйте только цифры 0-9 разделитель дроби '.' " +
//                    "и знаки математических операций '+' '-' '*' '/' ");
        }
        // вывод исключений и их обработка
        // возврат полученной строки в нераспарсенном виде в соответствующее поле


        System.out.println("Validator | конец работы");
        return false;
    }
}
