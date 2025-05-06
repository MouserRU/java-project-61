package hexlet.code.games;

import java.security.SecureRandom;

public class Prime {

    // Метод возвращает условие игры
    public static String introductoryNote() { // Метод получает параметр содержащий имя игры
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }

    // Метод формирует вопрос и правильный ответ
    public static String question(StringBuilder rightAnswer) {
        SecureRandom rnd = new SecureRandom();
        int maxNumber = 100; // Максимальное значение числа из условия игры
        int number = rnd.nextInt(maxNumber) + 1; // Переменная условия получает значение от 1 до 1 до maxNumber

        // проверяем number на простоту
        boolean isPrime = true;
        for (int i = 2; i <= (int) Math.sqrt(number); i++) {
            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }
        rightAnswer.append(isPrime ? "yes" : "no");
        return String.valueOf(number);
    }

}
