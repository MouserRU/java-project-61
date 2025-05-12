package hexlet.code.games;

import java.security.SecureRandom;

public class Progression {

    // Метод возвращает условие игры
    public static String introductoryNote() { // Метод получает параметр содержащий имя игры
        return "What number is missing in the progression?";
    }

    // Метод формирует вопрос и правильный ответ
    public static String question(StringBuilder rightAnswer) {
        SecureRandom rnd = new SecureRandom();
        final int range = 10; // Диапазон дла получения случайного числа
        final int minLengthProgression = 6; // Минимальная длина прогрессии
        final int lengthProgression = rnd.nextInt(range) + minLengthProgression; // устанавливаем длину
                // прогрессии 6..15 номеров
        final int stepProgression = rnd.nextInt(range) + 1; // Шаг прогрессии
        int sequenceNumber = rnd.nextInt(lengthProgression); // Порядковый номер искомого числа
        StringBuilder stringProgression = new StringBuilder(); // Строка хранящая прогрессию
        int number = rnd.nextInt(range); // Задаём первое число прогрессии
        for (int i = 0; i < lengthProgression; i++) {
            if (i != sequenceNumber) {
                stringProgression.append(number).append(" ");
                number += stepProgression;
            } else {
                stringProgression.append(".. ");
                rightAnswer.append(number);
                number += stepProgression;
            }
        }
        return stringProgression.toString();
    }
}
