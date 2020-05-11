package com.zufrost.learn;

import com.zufrost.learn.entity.StringExpression;
import com.zufrost.learn.service.Compute;
import com.zufrost.learn.service.ConsoleReadWrite;
import com.zufrost.learn.service.Parser;
import com.zufrost.learn.service.Validator;

import java.util.List;

public class Calculator {
    public static void main(String[] args) {

        StringExpression stringExpression = new StringExpression();
//        Validator validator = new Validator();
        stringExpression.setStringExpression(new ConsoleReadWrite().readStringExpressionFromConsole());

        //если валидатор пройден - отправляем строку на парсер
        try {
            if (Validator.checkStringExpression(stringExpression.getStringExpression())) {
//                System.out.println(Parser.parser(stringExpression.getStringExpression()));
//                System.out.println(Compute.computing(stringExpression.getStringExpression()));
                String rPN = Parser.parseToString(stringExpression.getStringExpression());
                System.out.println(rPN);
                List<String> postfix = Parser.parseToList(stringExpression.getStringExpression());
                for (String element : postfix) {
                    System.out.print(element + " ");
                }
                System.out.println();
//                System.out.println(Compute.calculation(Parser.parseToString(stringExpression.getStringExpression())));



            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }






//        System.out.println(stringExpression.getStringExpression());
//        System.out.println(stringExpression);


//        if (validator.checkStringExpression(stringExpression.getStringExpression())) {
//            System.out.println("проверка строки " + stringExpression.getStringExpression() + " на валидность прошла успешно");
//        } else {
//            System.out.println("проверка строки " + stringExpression.getStringExpression() + " на валидность не прошла");
//        }
    }
}
