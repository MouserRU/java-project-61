package hexlet.code.games;

import java.security.SecureRandom;

public class Even {

    // Метод возвращает условие игры
    public static String introductoryNote() { // Метод получает параметр содержащий имя игры
        String string = "\"Answer 'yes' if the number is even, otherwise answer 'no'.\"?";
        return string;
    }

    // Метод формирует вопрос и правильный ответ
    public static String question(StringBuilder rightAnswer) {
        SecureRandom rnd = new SecureRandom();
        int number = rnd.nextInt(100) + 1; // Переменная условия инициализированная случайным числом
        if (number % 2 == 0) {
            rightAnswer.append("yes");
        } else {
            rightAnswer.append("no");
        }
        return String.valueOf(number);
    }
}
