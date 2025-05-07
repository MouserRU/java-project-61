package hexlet.code.games;

import java.security.SecureRandom;

public class Gcd {

    // Метод возвращает условие игры
    public static String introductoryNote() { // Метод получает параметр содержащий имя игры
        return "Find the greatest common divisor of given numbers.";
    }

    // Метод формирует вопрос и правильный ответ
    public static String question(StringBuilder rightAnswer) {
        SecureRandom rnd = new SecureRandom();
        final int range = 10; // Диапазон для генерации числа из условия игры
        final int rangeMult = 10; // Диапазон для генерации множителя
        int mult = rnd.nextInt(rangeMult) + 1; // Общий множитель
        int number1 = (rnd.nextInt(range) + 1) * mult; // Первое число
        int number2 = (rnd.nextInt(range) + 1) * mult; // Второе число

        // Вычисление НОД
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

        rightAnswer.append(gcd);
        return number1 + " " + number2;
    }
}
