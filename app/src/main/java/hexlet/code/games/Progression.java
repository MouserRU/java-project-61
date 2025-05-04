package hexlet.code.games;

import java.security.SecureRandom;

public class Progression {

    // Метод возвращает условие игры
    public static String introductoryNote() { // Метод получает параметр содержащий имя игры
        String string = "Find the greatest common divisor of given numbers.";
        return string;
    }

    // Метод формирует вопрос и правильный ответ
    public static String question(StringBuilder rightAnswer) {
        SecureRandom rnd = new SecureRandom();
        final int lenProgression = rnd.nextInt(10) +6; // устанавливаем длину прогрессии 6..15 номеров
        final int step = rnd.nextInt(10) + 1; // Шаг прогрессии
        int sequenceNumber = rnd.nextInt(lenProgression); // Порядковый номер искомого числа
        String stringProgression = ""; // Строка хранящая прогрессию
        int number = rnd.nextInt(10); // Задаём первое число прогрессии
        for (int i = 0; i < lenProgression; i++) {
            if (i != sequenceNumber) {
                stringProgression += (number + " ");
                number += step;
            } else {
                stringProgression += ".. ";
                rightAnswer = rightAnswer.append(number);
                number += step;
            }
        }
        return stringProgression;
    }
}
