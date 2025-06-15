package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Even {

    // Метод генерирует данные игры:
    public  static void generate() {
        // Создание строки с вопросом
        final String questionLine = "Answer 'yes' if the number is even, otherwise answer 'no'.";

        // Объявление массива для хранения вопросов и ответов
        // Массив для хранения вопросов и ответов
        // Ёмкость массива вопросов / ответов
        final int capacity = 2;
        String[][] questionsAndAnswers = new String[Engine.NUMBER_OF_CYCLES][capacity];

        // Генерация вопросов и ответов
        // Нижнее значение диапазона
        final int lowerValue = 1;
        // Верхнее значение диапазона
        final int upperValue = 100;
        for (String[] array : questionsAndAnswers) {
            int number = Utils.intRnd(lowerValue, upperValue);

            // Заполнение ячейки с вопросом
            array[Engine.QUESTION] = String.valueOf(number);

            // Заполнение ячейки с ответом
            array[Engine.ANSWER] = number % 2 == 0 ? "yes" : "no";
        }

        // Вызываем Игровой движок
        Engine.game(questionLine, questionsAndAnswers);

    }

}
