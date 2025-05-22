package hexlet.code.games;

import hexlet.code.Engine;

import java.security.SecureRandom;

public class Progression {

    // Метод генерирует данные игры:
    public  static void generate() {
        // Создание строки с вопросом
        final String questionLine = "What number is missing in the progression?";

        // Количество циклов игры
        final int numberOfQuestions = 3;

        // Объявление массива для хранения вопросов и ответов
        // Второй индекс: 0 - соответствует ячейке с вопросом
        final int question = 0;
        // Второй индекс: 1 - соответствует ячейке с ответом
        final int answer = 1;

        // Ёмкость массива вопросов / ответов
        final int capasity = 2;
        String[][] questionsAndAnswers = new String[numberOfQuestions][capasity];

        SecureRandom rnd;
        rnd = new SecureRandom();

        // Генерация вопросов и ответов
        // Диапазон дла получения случайного числа
        final int range = 10;

        // Минимальная длина прогрессии
        final int minLengthProgression = 6;

        // Диапазон ширины прогрессии
        final int rangelength = 10;

        // Диапазон шага прогрессии
        final int rangeStep = 10;

        for (String[] array : questionsAndAnswers) {

            // устанавливаем длину прогрессии
            int lengthProgression = rnd.nextInt(rangelength) + minLengthProgression;

            // Шаг прогрессии
            int stepProgression = rnd.nextInt(rangeStep) + 1;

            // Номер искомого числа
            int sequenceNumber = rnd.nextInt(lengthProgression);

            // Строка хранящая прогрессию
            StringBuilder stringProgression = new StringBuilder();

            // Инициализируем переменную для сохранения ответа в строковом представлении
            String rightAnswer = "";

            // Задаём первое число прогрессии
            int number = rnd.nextInt(range);

            for (int i = 0; i < lengthProgression; i++) {
                if (i != sequenceNumber) {
                    stringProgression.append(number).append(" ");
                    number += stepProgression;
                } else {
                    stringProgression.append(".. ");
                    rightAnswer = String.valueOf(number);
                    number += stepProgression;
                }
            }

            // Заполнение ячейки с вопросом
            array[question] = stringProgression.toString();

            // Заполнение ячейки с ответом
            array[answer] = rightAnswer;
        }

        // Вызываем Игровой движок
        Engine.game(questionLine, questionsAndAnswers);

    }

}

/*

public class Progression {

    // Метод возвращает условие игры
    public static String introductoryNote() { // Метод получает параметр содержащий имя игры
        return "What number is missing in the progression?";
    }

    // Метод формирует вопрос и правильный ответ
    public static String question(StringBuilder rightAnswer) {
        SecureRandom rnd = new SecureRandom();
        final int range = 10; // Диапазон дла получения случайного числа
        final int minLengthProgression = 6; // Минимальная длина прогрессии
        final int lengthProgression = rnd.nextInt(range) + minLengthProgression; // устанавливаем длину
                // прогрессии 6..15 номеров
        final int stepProgression = rnd.nextInt(range) + 1; // Шаг прогрессии
        int sequenceNumber = rnd.nextInt(lengthProgression); // Порядковый номер искомого числа
        StringBuilder stringProgression = new StringBuilder(); // Строка хранящая прогрессию
        int number = rnd.nextInt(range); // Задаём первое число прогрессии
        for (int i = 0; i < lengthProgression; i++) {
            if (i != sequenceNumber) {
                stringProgression.append(number).append(" ");
                number += stepProgression;
            } else {
                stringProgression.append(".. ");
                rightAnswer.append(number);
                number += stepProgression;
            }
        }
        return stringProgression.toString();
    }
}

*/
