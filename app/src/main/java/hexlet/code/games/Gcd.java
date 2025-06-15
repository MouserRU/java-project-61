package hexlet.code.games;

import hexlet.code.Engine;

import static hexlet.code.Utils.intRnd;

public class Gcd {

    // Метод генерирует данные игры:
    public  static void generate() {
        // Создание строки с вопросом
        final String questionLine = "Find the greatest common divisor of given numbers.";

        // Объявление массива для хранения вопросов и ответов
        // Массив для хранения вопросов и ответов
        // Индекс для вопросов / ответов
        final int capacity = 2;
        String[][] questionsAndAnswers = new String[Engine.NUMBER_OF_CYCLES][capacity];

        // Диапазон для генерации числа из условия игры
        final int range = 10;

        // Диапазон для генерации множителя
        final int rangeMultiple = 10;

        // Генерация вопросов и ответов
        for (String[] array : questionsAndAnswers) {

            int multiple = intRnd(1, rangeMultiple); // Общий множитель
            int number1 = intRnd(1, range) * multiple; // Первое число
            int number2 = intRnd(1, range) * multiple; // Второе число

            // Заполнение ячейки с вопросом
            array[Engine.QUESTION] = number1 + " " + number2;

            // Заполнение ячейки с ответом
            array[Engine.ANSWER] = String.valueOf(gcd(number1, number2));
        }

        // Вызываем Игровой движок
        Engine.game(questionLine, questionsAndAnswers);

    }

    // Вычисление НОД
    static int gcd(int number1, int number2) {
        int gcd = 1;
        int num1 = number1;
        int num2 = number2;
        while (num1 != 0) {
            if (num1 >= num2) {
                num1 %= num2;
                gcd = num2;
            } else {
                int numTemp = num1;
                num1 = num2;
                num2 = numTemp;
            }
        }
        return gcd;
    }

}
