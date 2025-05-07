package hexlet.code.games;

import java.security.SecureRandom;

public class Even {

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
