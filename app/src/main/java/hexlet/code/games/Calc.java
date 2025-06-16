package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Calc {
    // Метод генерирует данные игры:
    public static void generate() {

        // Создание строки с вопросом
        final String questionLine = "What is the result of the expression?";

        // Объявление массива для хранения вопросов и ответов
        // Второй индекс: 0 - соответствует ячейке с вопросом

        // Ёмкость массива вопросов / ответов
        final int capacity = 2;
        String[][] questionsAndAnswers = new String[Engine.NUMBER_OF_CYCLES][capacity];

        // Генерация вопросов и ответов
        final int lowerValueForMultiplication = 1;
        final int upperValueForMultiplication = 10;
        final int lowerValueForOtherOrations = 1;
        final int upperValueForOtherOrations = 100;

        final int numberOfMath = 3; // Число математических операций

        for (String[] array : questionsAndAnswers) {

            // Получаем номер математического оператора
            int operator = Utils.intRnd(numberOfMath - 1);

            // Получаем символьное представление математического оператора
            char operatorChr;

            operatorChr = switch (operator) {
                case 0 -> '+';
                case 1 -> '-';
                case 2 -> '*';
                default -> throw new RuntimeException("Unknown operator " + operator);
            };

            // Получаем числа для математических операций
            int number1;
            int number2;
            if (operator == 2) {
                // получение первого числа для операции умножения
                number1 = Utils.intRnd(lowerValueForMultiplication, upperValueForMultiplication);
                // получение второго числа для операции умножения
                number2 = Utils.intRnd(lowerValueForMultiplication, upperValueForMultiplication);

            } else {
                // получение первого числа для операций сложения и вычитания
                number1 = Utils.intRnd(lowerValueForOtherOrations, upperValueForOtherOrations);
                // получение второго числа для операций сложения и вычитания
                number2 = Utils.intRnd(lowerValueForOtherOrations, upperValueForOtherOrations);
            }

            // Заполнение ячейки с вопросом
            array[Engine.QUESTION] = number1 + " " + operatorChr + " " + number2;

            // Получение правильного ответа и помещение его в ячейку массива
            int result = resultCalculate(number1, number2, operatorChr);
            array[Engine.ANSWER] = String.valueOf(result);


        }

        // Вызываем Игровой движок
        Engine.game(questionLine, questionsAndAnswers);

    }

    static int resultCalculate(int num1, int num2, char operatorChr) {
        return switch (operatorChr) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            default -> throw new RuntimeException("Unknown operator " + operatorChr);
        };
    }

}
