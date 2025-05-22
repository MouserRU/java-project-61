package hexlet.code.games;
import hexlet.code.Engine;
import java.security.SecureRandom;

public class Gcd {

    // Метод генерирует данные игры:
    public  static void generate() {
        // Создание строки с вопросом
        final String questionLine = "Find the greatest common divisor of given numbers.";

        // Количество циклов игры
        final int numberOfQuestions = 3;

        // Объявление массива для хранения вопросов и ответов
        // Первый индекс: 0 - соответствует ячейке с вопросом
        final int question = 0;
        // Первый индекс: 1 - соответствует ячейке с ответом
        final int answer = 1;

        // Массив для хранения вопросов и ответов
        // Индекс для вопросов / ответов
        final int capasity = 2;
        String[][] questionsAndAnswers = new String[numberOfQuestions][capasity];

        SecureRandom rnd;
        rnd = new SecureRandom();

        // Диапазон для генерации числа из условия игры
        final int range = 10;

        // Диапазон для генерации множителя
        final int rangeMult = 10;

        // Генерация вопросов и ответов
        for (String[] array : questionsAndAnswers) {

            int mult = rnd.nextInt(rangeMult) + 1; // Общий множитель
            int number1 = (rnd.nextInt(range) + 1) * mult; // Первое число
            int number2 = (rnd.nextInt(range) + 1) * mult; // Второе число

            // Заполнение ячейки с вопросом
            array[question] = number1 + " " + number2;

            // Заполнение ячейки с ответом
            array[answer] = String.valueOf(gcd(number1, number2));
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
