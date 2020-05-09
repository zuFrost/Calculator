package com.zufrost.learn.service;

import java.util.Scanner;

public class ConsolReadWrite implements IConsolReadWrite{
    @Override
    public String read() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input arithmetic expression: ");
        String string = scanner.nextLine();
        System.out.println();
        System.out.println("вы ввели: " + string);

        // проверка на правильность ввода
        if (!string.matches("[\\d0-9+\\-*\\/.]")) {
            System.out.println("строка содержит запрещенные символы");
        }
        // вывод исключений и их обработка
        // возврат полученной строки в нераспарсенном виде в соответствующее поле



        return null;
    }
}
