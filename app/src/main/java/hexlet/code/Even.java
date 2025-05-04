package hexlet.code;

import java.security.SecureRandom;
import java.util.Scanner;

public class Even {
    // Логика игры Even
    static void game() {
        String playerName = greeting(); // Переменная хранящая имя игрока
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        SecureRandom rnd = new SecureRandom();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            int number = rnd.nextInt(100) + 1; // Переменная условия инициализированная случайным числом
            System.out.println("Question: " + number);
            System.out.print("Your answer: ");
            String playerAnswer = scanner.nextLine(); // Переменная содержащая ответ игрока
            String rightAnswer = rightAnswer(number); // Переменная содержащая верный ответ
            if (playerAnswer.equals(rightAnswer)) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + playerAnswer + "' is wrong answer ;(. Correct answer was '" + rightAnswer + "'.\n" +
                        "Let's try again, " + playerName + "!");
                return;
            }
        }
        System.out.println("Congratulations, " + playerName + "!");
    }

    // Вывод приветствия
    static String greeting() {
        String playerName;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nWelcome to the Brain Games!");
        System.out.print("May I have your name? ");
        playerName = scanner.nextLine();
        System.out.println("Hello, " + playerName + "!");
        return playerName;
    }

    // Вычисление правильного ответа
    static String rightAnswer(int number) {
        if (number % 2 == 0) {
            return "yes";
        } else {
            return "no";
        }
    }
}
