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
        final int RANGE = 10; // Диапазон дла получения случайнолго числа
        final int MIN_LENGTH_PROGRESSION = 6; // Минимальная длина прогрессии
        final int LENGTH_PROGRESSION = rnd.nextInt(RANGE) + MIN_LENGTH_PROGRESSION; // устанавливаем длину
                // прогрессии 6..15 номеров
        final int STEP_PROGRESSION = rnd.nextInt(RANGE) + 1; // Шаг прогрессии
        int sequenceNumber = rnd.nextInt(LENGTH_PROGRESSION); // Порядковый номер искомого числа
        StringBuilder stringProgression = new StringBuilder(); // Строка хранящая прогрессию
        int number = rnd.nextInt(RANGE); // Задаём первое число прогрессии
        for (int i = 0; i < LENGTH_PROGRESSION; i++) {
            if (i != sequenceNumber) {
                stringProgression.append(number).append(" ");
                number += STEP_PROGRESSION;
            } else {
                stringProgression.append(".. ");
                rightAnswer.append(number);
                number += STEP_PROGRESSION;
            }
        }
        return stringProgression.toString();
    }
}
