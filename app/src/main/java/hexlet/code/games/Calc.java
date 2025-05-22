package hexlet.code.games;
import hexlet.code.Engine;
import java.security.SecureRandom;

public class Calc {

    // Метод генерирует данные игры:
    public  static void generate() {
        // Создание строки с вопросом
        final String questionLine = "What is the result of the expression?";

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
        final int range1 = 21; // Диапазон для генерации числа из условия игры для операции умножения
        final int offset1 = -10; // Смещение числа в минус для операции умножения
        final int range2 = 201; // Диапазон для генерации числа из условия игры для операций сложения и вычитания
        final int offset2 = -100; // Смещение числа в минус для операций сложения и вычтания
        final int numberOfMath = 3; // Число математических операций
        final String operators = "+-*"; // Строка с возможными математическими операторами
        final int add = 0; // Индекс символа оператора сложения в operators
        final int sub = 1; // Индекс символа оператора вычитания в operators
        final int mult = 2; // Индекс символа оператора умножения в operators


        for (String[] array : questionsAndAnswers) {

            // Получаем номер математического оператора
            int operator = rnd.nextInt(numberOfMath);

            // Получаем символьное представление математического оператора
            char operatorChr;
            operatorChr = operators.charAt(operator);

            // Получаем числа для математических операций
            int number1;
            int number2;
            if (operator == 2) {
                number1 = rnd.nextInt(range1) + offset1; // получение первого числа в диапазоне от -10 до 10 для
                // операции умножения
                number2 = rnd.nextInt(range1) + offset1; // получение второго числа в диапазоне от -10 до 10 для
                // операции умножения
            } else {
                number1 = rnd.nextInt(range2) + offset2; // получение первого числа в диапазоне от -100 до 100 для
                // операций сложения и вычитания
                number2 = rnd.nextInt(range2) + offset2; // получение второго числа в диапазоне от -100 до 100 для
                // операций сложения и вычитания
            }

            // Заполнение ячейки с вопросом
            array[question] = number1 + " " + operatorChr + " " + number2;

            // Получение правильного ответа и помещение его в ячейку массива
            if (operator == add) {
                array[answer] = String.valueOf(number1 + number2);
            }
            if (operator == sub) {
                array[answer] = String.valueOf(number1 - number2);
            }
            if (operator == mult) {
                array[answer] = String.valueOf(number1 * number2);
            }
        }

        // Вызываем Игровой движок
        Engine.game(questionLine, questionsAndAnswers);

    }

}
