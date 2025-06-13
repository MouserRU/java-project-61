package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Even {

    // Метод генерирует данные игры:
    public  static void generate() {
        // Создание строки с вопросом
        final String questionLine = "Answer 'yes' if the number is even, otherwise answer 'no'.";

        // Количество циклов игры
        final int numberOfQuestions = Engine.numberOfCycles;

        // Объявление массива для хранения вопросов и ответов
        // Первый индекс: 0 - соответствует ячейке с вопросом
        final int question = 0;
        // Первый индекс: 1 - соответствует ячейке с ответом
        final int answer = 1;

        // Массив для хранения вопросов и ответов
        // Ёмкость массива вопросов / ответов
        final int capacity = 2;
        String[][] questionsAndAnswers = new String[numberOfQuestions][capacity];

        // Генерация вопросов и ответов
        // Нижнее значение диапазона
        final int lowerValue = 1;
        // Верхнее значение диапазона
        final int upperValue = 100;
        for (String[] array : questionsAndAnswers) {
            int number = Utils.intRnd(lowerValue, upperValue);

            // Заполнение ячейки с вопросом
            array[question] = String.valueOf(number);

            // Заполнение ячейки с ответом
            array[answer] = number % 2 == 0 ? "yes" : "no";
        }

        // Вызываем Игровой движок
        Engine.game(questionLine, questionsAndAnswers);

    }

}
