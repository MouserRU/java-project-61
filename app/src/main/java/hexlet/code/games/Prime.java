package hexlet.code.games;

import hexlet.code.Engine;

import java.security.SecureRandom;

public class Prime {

    // Метод генерирует данные игры:
    public  static void generate() {
        // Создание строки с вопросом
        final String questionLine = "Answer 'yes' if the number is even, otherwise answer 'no'.";

        // Количество циклов игры
        final int numberOfQuestions = 3;

        // Объявление массива для хранения вопросов и ответов
        // Второй индекс: 0 - соответствует ячейке с вопросом
        final int question = 0;
        // Второй индекс: 1 - соответствует ячейке с ответом
        final int answer = 1;

        // Ёмкость массива для вопросов / ответов
        final int capasity = 2;
        String[][] questionsAndAnswers = new String[numberOfQuestions][capasity];

        SecureRandom rnd;
        rnd = new SecureRandom();

        // Генерация вопросов и ответов
        final int range = 100; // Диапазон для генерации числа из условия игры
        for (String[] array : questionsAndAnswers) {

            // Переменная условия получает значение от 1 до 100
            int number = rnd.nextInt(range) + 1;

            // Заполнение ячейки с вопросом
            array[question] = String.valueOf(number);

            // Заполнение ячейки с ответом
            array[answer] = isPrime(number) ? "yes" : "no";
        }

        // Вызываем Игровой движок
        Engine.game(questionLine, questionsAndAnswers);

    }

    // Проверяем number на простоту
    static boolean isPrime(int number) {
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
