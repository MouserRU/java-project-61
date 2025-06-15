package hexlet.code;

import java.util.Scanner;

public class Engine {

    // Устанавливаем количество циклов игры
    public static final int NUMBER_OF_CYCLES = 3;

    // Индекс ячейки массива с вопросом
    public static final int QUESTION = 0;

    // Индекс ячейки массива с ответом
    public static final int ANSWER = 1;


    public static void game(String questionLine, String[][] questionsAndAnswers) {

        Scanner input = new Scanner(System.in);

        // Выводим приветствие и получаем имя игрока
        String playerName;
        System.out.println("\nWelcome to the Brain Games!\n"
                + "May I have your name?");
        playerName = input.nextLine();
        System.out.println("Hello, " + playerName + "!");

        // Инициализируем флаг выигрыша игрока
        boolean isWin;

        // Игровой цикл, количество проходов определено константой NUMBER_OF_CYCLES
        for (String[] questionAndAnswer : questionsAndAnswers) {

            //Выводим строку с заданием игры
            System.out.println(questionLine);

            // Выводим вопрос
            System.out.println("Question: " + questionAndAnswer[QUESTION]);

            // Выводим приглашение к вводу ответа
            System.out.print("Your answer: ");

            // Получаем ответ игрока
            String playerAnswer = input.nextLine();

            // Валидация ответа
            // Флаг правильного ответа
            isWin = playerAnswer.equals(questionAndAnswer[ANSWER]);

            // Проверка ответа игрока
            if (isWin) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + playerAnswer + "' is wrong answer ;(. Correct answer was '"
                        + questionAndAnswer[ANSWER] + "'.\n"
                        + "Let's try again, " + playerName + "!");
                return;
            }
        }

        // Выводим итоговое сообщение
        System.out.println("Congratulations, " + playerName + "!");

    }

}
