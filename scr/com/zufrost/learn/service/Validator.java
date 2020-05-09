package com.zufrost.learn.service;

public class Validator implements IValidator{
    @Override
    public boolean checkStringExpression(String stringExpression) {
        //get stringExpression to validate, from String Entity

        // проверка на правильность ввода
//        if (!stringExpression.matches("[\\d0-9+\\-*\\/.]")) {
//            System.out.println("строка содержит запрещенные символы");
//        }
        // вывод исключений и их обработка
        // возврат полученной строки в нераспарсенном виде в соответствующее поле


        return false;
    }
}
