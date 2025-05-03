package hexlet.code;

import java.util.Scanner;
import hexlet.code.games.*;
import hexlet.code.games.Even;

public class Engine {

    static void engine(String nameOfTheGame) { // Метод получает параметр содержащий имя игры
        String playerName = greeting(); // Выводим приветствие, получаем имя игрока
        final  int numberOfRounds = 3; // Количество раундов игры
        boolean isWin = false; // Флаг победы игрока
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < numberOfRounds; i++) {

            String note = ""; // Строковая переменная хранящая условие игры
            String question =""; // Строковая переменная хранящая вопрос
            StringBuilder rightAnswer = new StringBuilder(); // Переменная хранящая правильный ответ


            switch (nameOfTheGame) {
                case "Even": {
                    note = Even.introductoryNote();
                    question = Even.question(rightAnswer);
                }
                case "Calc": {
                    note = Calc.introductoryNote();
                    question = Calc.question(rightAnswer);
                }
            }
            System.out.println(note);
            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
            String playerAnswer = input.nextLine(); // Получаем ответ игрока
            if (playerAnswer.contentEquals(rightAnswer)) {
                System.out.println("Correct!");
                isWin = true;
            } else {
                System.out.println("'" + playerAnswer + "' is wrong answer ;(. Correct answer was '"
                        + rightAnswer + "'.");
                isWin = false;
                break;
            }
        }
        //
        if (isWin) {
            System.out.println("Congratulations, " + playerName + "!");
        } else {
            System.out.println("Let's try again, " + playerName + "!");
        }
    }

    static String greeting() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        final String playerName = scanner.nextLine();
        System.out.println("Hello, " + playerName + "!");
        return playerName;
    }
}
