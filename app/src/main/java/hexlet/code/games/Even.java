package hexlet.code.games;

import java.security.SecureRandom;

public class Even {

    // Метод генерирует данные игры:
    //
    public  static void generate() {
        // Создание строки с вопросом
        final String questionLine = "Answer 'yes' if the number is even, otherwise answer 'no'.";

        // Количество циклов игры
        final int numberOfQuestions = 3;

        // Объявление массива для хранения вопросов и ответов
        // Первый индекс: 0 - соответствует ячейке с вопросом
        final int questionIndex = 0;
        // Первый индекс: 1 - соответствует ячейке с ответом
        final int answerIndeks = 1;
        // Ёмкость первого индекса
        final int cfi = 2; 
        String[][] questionsAndAnswers = new String[cfi][numberOfQuestions];

        SecureRandom rnd = new SecureRandom();

        // Генерация вопросов и ответов
        final int range = 100; // Диапазон для генерации числа из условия игры
        for (int i = 0; i < numberOfQuestions; i++) {
            questionsAndAnswers[questionIndex][i] = 
        }
    }

    // -------------------------------------------------------------------------------------
    // Метод возвращает условие игры
    public static String introductoryNote() { // Метод получает параметр содержащий имя игры
        return "\"Answer 'yes' if the number is even, otherwise answer 'no'.\"?";
    }

    // Метод формирует вопрос и правильный ответ
    public static String question(StringBuilder rightAnswer) {
        SecureRandom rnd = new SecureRandom();
        final int range = 100; // Диапазон для генерации числа из условия игры
        int number = rnd.nextInt(range) + 1; // Переменная условия
        if (number % 2 == 0) {
            rightAnswer.append("yes");
        } else {
            rightAnswer.append("no");
        }
        return String.valueOf(number);
    }
}
