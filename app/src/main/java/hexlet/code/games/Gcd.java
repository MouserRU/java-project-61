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
        int maxNumber = 10; // Максимальное значение числа из условия игры
        int maxM = 10; // максимальное значение множителя
        int m = rnd.nextInt(maxM) + 1; // Общий множитель
        int number1 = (rnd.nextInt(maxNumber) + 1) * m; // Первое число
        int number2 = (rnd.nextInt(maxNumber) + 1) * m; // Второе число

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
