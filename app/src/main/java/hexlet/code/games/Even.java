package hexlet.code.games;

import java.util.Random;

public class Even {

    // Метод возвращает условие игры
    public static String introductoryNote() { // Метод получает параметр содержащий имя игры
        return "\"Answer 'yes' if the number is even, otherwise answer 'no'.\"?";
    }

    // Метод производит игровое действие
    public static String question(StringBuilder rightAnswer) {
        Random rnd = new Random();
        int number = rnd.nextInt(100) + 1; // Переменная условия инициализированная случайным числом
        if (number % 2 == 0) {
            rightAnswer.append("yes");
        } else {
            rightAnswer.append("no");
        }
        return String.valueOf(number);
    }
}
