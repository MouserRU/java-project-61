package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Calc {
    // Метод генерирует данные игры:
    public static void generate() {

        // Создание строки с вопросом
        final String questionLine = "What is the result of the expression?";

        // Количество циклов игры
        final int numberOfQuestions = Engine.numberOfCycles;

        // Объявление массива для хранения вопросов и ответов
        // Второй индекс: 0 - соответствует ячейке с вопросом
        final int question = 0;
        // Второй индекс: 1 - соответствует ячейке с ответом
        final int answer = 1;

        // Ёмкость массива вопросов / ответов
        final int capacity = 2;
        String[][] questionsAndAnswers = new String[numberOfQuestions][capacity];

        // Генерация вопросов и ответов
        final int lowerValueForMultiplication = -10;
        final int upperValueForMultiplication = 10;
        final int lowerValueForOtherOrations = -100;
        final int upperValueForOtherOrations = 100;
        final int numberOfMath = 3; // Число математических операций

        for (String[] array : questionsAndAnswers) {

            // Получаем номер математического оператора
            int operator = Utils.intRnd(numberOfMath);

            // Получаем символьное представление математического оператора
            char operatorChr;

            operatorChr = switch (operator) {
                case 0 -> '+';
                case 1 -> '-';
                default -> '*';
            };

            // Получаем числа для математических операций
            int number1;
            int number2;
            if (operator == 2) {
                do {
                    // получение первого числа для операции умножения
                    number1 = Utils.intRnd(lowerValueForMultiplication, upperValueForMultiplication);

                    // получение второго числа для операции умножения
                    number2 = Utils.intRnd(lowerValueForMultiplication, upperValueForMultiplication);
                } while (number1 == 0 || number2 == 0);

            } else {
                do {
                    // получение первого числа для операций сложения и вычитания
                    number1 = Utils.intRnd(lowerValueForOtherOrations, upperValueForOtherOrations);

                    // получение второго числа для операций сложения и вычитания
                    number2 = Utils.intRnd(lowerValueForOtherOrations, upperValueForOtherOrations);
                } while (number1 == 0 || number2 == 0);
            }

            // Заполнение ячейки с вопросом
            array[question] = number1 + " " + operatorChr + " " + number2;

            // Получение правильного ответа и помещение его в ячейку массива
            int result;
            result = resultCalculate(number1, number2, operatorChr);
            array[answer] = String.valueOf(result);

        }

        // Вызываем Игровой движок
        Engine.game(questionLine, questionsAndAnswers);

    }

    static int resultCalculate ( int num1, int num2, char operator){
        return switch (operator) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            default -> num1 * num2;
        };
    }

}
