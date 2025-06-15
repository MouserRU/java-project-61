package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Prime {

    // Метод генерирует данные игры:
    public  static void generate() {
        // Создание строки с вопросом
        final String questionLine = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

        // Объявление массива для хранения вопросов и ответов
        // Ёмкость массива для вопросов / ответов
        final int capacity = 2;
        String[][] questionsAndAnswers = new String[Engine.NUMBER_OF_CYCLES][capacity];

        // Генерация вопросов и ответов
        // Нижняя граница диапазона
        final int lowerValue = 1;

        // Верхняя граница диапазона
        final int upperValue = 100;

        for (String[] array : questionsAndAnswers) {

            // Переменная условия получает значение от 1 до 100
            int number = Utils.intRnd(lowerValue, upperValue);

            // Заполнение ячейки с вопросом
            array[Engine.QUESTION] = String.valueOf(number);

            // Заполнение ячейки с ответом
            array[Engine.ANSWER] = isPrime(number) ? "yes" : "no";
        }

        // Вызываем Игровой движок
        Engine.game(questionLine, questionsAndAnswers);

    }

    // Проверяем number на простоту
    static boolean isPrime(int number) {
        // По определению, простое число всегда больше 1
        if (number <= 1) {
            return false;
        }

        // И делится только на 1 и само себя
        boolean isPrime = true;
        for (int i = 2; i <= (int) Math.sqrt(number); i++) {
            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }

}
