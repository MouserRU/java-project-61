package hexlet.code.games;
import hexlet.code.Engine;
import java.security.SecureRandom;

public class Even {

    // Метод генерирует данные игры:
    public  static void generate() {
        // Создание строки с вопросом
        final String questionLine = "Answer 'yes' if the number is even, otherwise answer 'no'.";

        // Количество циклов игры
        final int numberOfQuestions = 3;

        // Объявление массива для хранения вопросов и ответов
        // Первый индекс: 0 - соответствует ячейке с вопросом
        final int question = 0;
        // Первый индекс: 1 - соответствует ячейке с ответом
        final int answer = 1;

        // Массив для хранения вопросов и ответов
        // Ёмкость массива вопросов / ответов
        final int capasity = 2;
        String[][] questionsAndAnswers = new String[numberOfQuestions][capasity];

        SecureRandom rnd;
        rnd = new SecureRandom();

        // Генерация вопросов и ответов
        final int range = 100; // Диапазон для генерации числа из условия игры
        for (String[] array : questionsAndAnswers) {
            int number = rnd.nextInt(range);

            // Заполнение ячейки с вопросом
            array[question] = String.valueOf(number);

            // Заполнение ячейки с ответом
            array[answer] = number % 2 == 0 ? "yes" : "no";
        }

        // Вызываем Игровой движок
        Engine.game(questionLine, questionsAndAnswers);

    }

}
