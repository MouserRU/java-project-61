package hexlet.code.games;

import java.security.SecureRandom;

public class Calc {

    // Метод возвращает условие игры
    public static String introductoryNote() { // Метод получает параметр содержащий имя игры
        return "What is the result of the expression?";
    }

    // Метод производит игровое действие
    public static String question(StringBuilder rightAnswer) {
        SecureRandom rnd = new SecureRandom();
        int operator = rnd.nextInt(3); // Номер математического оператора
        String operatorSting = switch (operator) {
            case 0 -> "+";
            case 1 -> "-";
            default -> "*";
        };
        int number1, number2;
        if(operator == 2) {
            number1 = rnd.nextInt(21) - 10; // получение первого числа в диапазоне от -10 до 10 для
                    // операции умножения
            number2 = rnd.nextInt(21) -10; // получение второго числа в диапазоне от -10 до 10 для
                    // операции умножения
        } else {
            number1 = rnd.nextInt(201) - 100; // получение первого числа в диапазоне от -100 до 100 для
                    // операций сложения и вычитания
            number2 = rnd.nextInt(201) - 100; // получение первого числа в диапазоне от -100 до 100 для
                    // операций сложения и вычитания
        }

        // Формирование правильного ответа
        rightAnswer.append(switch (operator) {
                    case 0 -> String.valueOf(number1 + number2);
                    case 1 -> String.valueOf(number1 - number2);
                    default -> String.valueOf(number1 * number2);
                }
          );
        return number1 + " " + operatorSting + " " + number2; // Формирование строки с заданием
    }

}
