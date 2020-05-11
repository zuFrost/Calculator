package com.zufrost.learn.service;

import java.util.Scanner;

public class ConsoleReadWrite implements IConsoleReadWrite {
    @Override
    public String readStringExpressionFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input arithmetical expression: ");
        return scanner.nextLine();
    }

    @Override
    public void writeAnswerToConsole(Double answer) {
        System.out.println("Ответ: " + answer);
    }
}
