package hexlet.code;

import java.util.Scanner;

public class Engine {

    // Устанавливаем количество циклов игры
    public static final int numberOfCycles = 3;

    public static void game(String questionLine, String[][] questionsAndAnswers) {

        Scanner input = new Scanner(System.in);

        // Выводим приветствие и получаем имя игрока
        String playerName;
        System.out.println("\nWelcome to the Brain Games!\n" +
                "May I have your name?");
        playerName = input.nextLine();
        System.out.println("Hello, " + playerName + "!");

        // Инициализируем счётчик циклов игры
        int counter = 0;

        // Индекс ячейки массива с вопросом
        final int question = 0;

        // Индекс ячейки массива с ответом
        final int answer = 1;

        // Инициализируем флаг выигрыша игрока
        boolean isWin;

        // Игровой цикл
        do {
            //Выводим строу с заданием игры
            System.out.println(questionLine);

            // Выводим вопрос
            System.out.println("Question: " + questionsAndAnswers[counter][question]);

            // Выводим приглашение к вводу ответа
            System.out.print("Your answer: ");

            // Получаем ответ игрока
            String playerAnswer = input.nextLine();

            // Валидация ответа
            // Флаг правильного ответа
            isWin = playerAnswer.equals(questionsAndAnswers[counter][answer]);

            // Проверка ответа игрока
            if (isWin) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + playerAnswer + "' is wrong answer ;(. Correct answer was '"
                        + questionsAndAnswers[counter][answer] + "'.\n" +
                        "Let's try again, " + playerName + "!");
                return;
            }

            ++counter;

        } while (counter < numberOfCycles);

        // Выводим итоговое сообщение
        System.out.println("Congratulations, " + playerName + "!");

    }

}
