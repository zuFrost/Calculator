package com.zufrost.learn.service;

public class Validator implements IValidator {
    @Override
    public boolean checkStringExpression(String stringExpression) {
        System.out.println("Validator | получил на обработку строку " + stringExpression);

        //проверка на пустую стоку
        if (stringExpression.equals("")) {
            throw new IllegalArgumentException("You input empty arithmetical expression");
        }
        // проверка на ()
        if (stringExpression.contains("(") || stringExpression.contains(")")) {
            throw new IllegalArgumentException("Данная версия программы не поддерживает скобки \"()\" " +
                    "\nИспользуйте только цифры 0-9 разделитель дроби '.' и знаки математических операций '+' '-' '*' '/' ");
        }
        // проверка на ,
        if (stringExpression.contains(",")) {
            throw new IllegalArgumentException("Используйте '.' для разделения целой и дробной части числа");
        }
        // проверка на правильность ввода
        if (!stringExpression.matches("[\\d0-9+\\-*\\/\\.]*")) {
            throw new IllegalArgumentException("Строка содержит запрещенные символы. " +
                    "\nИспользуйте только цифры 0-9 разделитель дроби '.' и знаки математических операций '+' '-' '*' '/' ");
        }
        //проверка на лидирующий '-' отрицательные числа \\A(-)
        if (stringExpression.startsWith("-")) {
            throw new IllegalArgumentException("Данная версия программы не поддерживает отрицательные числа");
        }
        //Поверка на дублирующиеся символы операций, введение некорректного выражения вида 4++2 и дублирующуюся точку
        if (stringExpression.matches(".*([\\+\\-\\*\\/\\.][\\+\\-\\*\\/\\.]+).*")) {
//            System.out.println("Поверка на дублирующиеся символы");
            throw new IllegalArgumentException("Не допускается введение некорректного выражения вида 4++2. " +
                    "\nТ.е. не может быть дублирующихся символов операций или двойного разделителя дроби вида 4..2 " +
                    "\nСочетания вида .+ или +. так же не допускаются");
        }


        // возврат полученной строки в нераспарсенном виде в соответствующее поле


        System.out.println("Validator | конец работы");
        return false;
    }
}
