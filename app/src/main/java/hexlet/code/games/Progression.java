package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Progression {

    // Метод генерирует данные игры:
    public  static void generate() {
        // Создание строки с вопросом
        final String questionLine = "What number is missing in the progression?";

        // Объявление массива для хранения вопросов и ответов
        // Ёмкость массива вопросов / ответов
        final int capacity = 2;
        String[][] questionsAndAnswers = new String[Engine.NUMBER_OF_CYCLES][capacity];

        // Нижнее значение диапазона
        final int lowerValueStep = 1;

        // Диапазон шага прогрессии
        // Верхнее значение диапазона
        final int upperValueStep = 10;

        // Минимальная длина прогрессии
        final int minLengthProgression = 6;

        // Длина прогрессии
        int lengthProgression;

        // Шаг прогрессии
        int stepProgression;

        // Генерация вопросов и ответов

        for (String[] array : questionsAndAnswers) {

            // Устанавливаем длину прогрессии
            // Нижняя граница диапазона
            final int lowerLimitRange = 1;
            // Верхняя граница диапазона
            final int upperLimitRange = 9;
            lengthProgression = Utils.intRnd(lowerLimitRange, upperLimitRange) + minLengthProgression;

            // Устанавливаем шаг прогрессии
            stepProgression = Utils.intRnd(lowerValueStep, upperValueStep);

            // Создаём массив для хранения прогрессии
            // Нижняя граница диапазона
            final int lowerLimitRangeOfNumber = 0;
            // Верхняя граница диапазона
            final int upperLimitRangeOfNumber = 10;
            // Задаём первое число прогрессии
            int number = Utils.intRnd(lowerLimitRangeOfNumber, upperLimitRangeOfNumber);
            String[] progression = makeArray(number, lengthProgression, stepProgression);

            // Номер искомого числа
            int sequenceNumber = Utils.intRnd(0, lengthProgression - 1);

            // Правильный ответ
            String rightAnswer = progression[sequenceNumber];

            // Заменяем число в массиве на точки
            progression[sequenceNumber] = "..";

            // Склеиваем массив в строку
            String stringProgression = String.join(" ", progression);

            // Заполнение ячейки с вопросом
            array[Engine.QUESTION] = stringProgression;

            // Заполнение ячейки с ответом
            array[Engine.ANSWER] = rightAnswer;
        }

        // Вызываем Игровой движок
        Engine.game(questionLine, questionsAndAnswers);

    }

    static String[] makeArray(int number, int lengthProgression, int stepProgression) {
        // Создаём массив для хранения прогрессии
        String[] progression = new String[lengthProgression];

        for (int i = 0; i < lengthProgression; i++) {
            progression[i] = Integer.toString(number);
            number += stepProgression;
        }

        return progression;
    }

}
