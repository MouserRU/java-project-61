package hexlet.code.games;

import java.security.SecureRandom;

public class Calc {

    // Метод возвращает условие игры
    public static String introductoryNote() { // Метод получает параметр содержащий имя игры
        return "What is the result of the expression?";
    }

    // Метод формирует вопрос и правильный ответ
    public static String question(StringBuilder rightAnswer) {
        SecureRandom rnd = new SecureRandom();
        final int range1 = 21; // Диапазон для генерации числа из условия игры для операции умножения
        final int offset1 = -10; // Смещение числа в минус для операции умножения
        final int range2 = 201; // Диапазон для генерации числа из условия игры для операций сложения и вычитания
        final int offset2 = -100; // Смещение числа в минус для операций сложения и вычтания
        final int numberOfMath = 3; // Число математических операций
        int operator = rnd.nextInt(numberOfMath); // Получаем номер математического оператора
        String operatorSting = switch (operator) {
            case 0 -> "+";
            case 1 -> "-";
            default -> "*";
        };
        int number1;
        int number2;
        if (operator == 2) {
            number1 = rnd.nextInt(range1) + offset1; // получение первого числа в диапазоне от -10 до 10 для
                    // операции умножения
            number2 = rnd.nextInt(range1) + offset1; // получение второго числа в диапазоне от -10 до 10 для
                    // операции умножения
        } else {
            number1 = rnd.nextInt(range2) + offset2; // получение первого числа в диапазоне от -100 до 100 для
                    // операций сложения и вычитания
            number2 = rnd.nextInt(range2) + offset2; // получение первого числа в диапазоне от -100 до 100 для
                    // операций сложения и вычитания
        }

        // Формирование правильного ответа
        rightAnswer.append(
            switch (operator) {
                case 0 -> String.valueOf(number1 + number2);
                case 1 -> String.valueOf(number1 - number2);
                default -> String.valueOf(number1 * number2);
            }
        );
        return number1 + " " + operatorSting + " " + number2; // Формирование строки с заданием
    }

}
