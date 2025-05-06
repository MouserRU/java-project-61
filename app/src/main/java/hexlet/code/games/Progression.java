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
        final int lenProgression = rnd.nextInt(10) + 6; // устанавливаем длину прогрессии 6..15 номеров
        final int step = rnd.nextInt(10) + 1; // Шаг прогрессии
        int sequenceNumber = rnd.nextInt(lenProgression); // Порядковый номер искомого числа
        StringBuilder stringProgression = new StringBuilder(); // Строка хранящая прогрессию
        int maxNumber = 10; // Максимальное значение первого чмсла прогресии
        int number = rnd.nextInt(maxNumber); // Задаём первое число прогрессии
        for (int i = 0; i < lenProgression; i++) {
            if (i != sequenceNumber) {
                stringProgression.append(number).append(" ");
                number += step;
            } else {
                stringProgression.append(".. ");
                rightAnswer.append(number);
                number += step;
            }
        }
        return stringProgression.toString();
    }
}
