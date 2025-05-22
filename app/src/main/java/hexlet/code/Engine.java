package hexlet.code;

import java.util.Scanner;

public class Engine {

    public static void game(String questionLine, String[][] questionsAndAnswers) {

        Scanner input = new Scanner(System.in);

        // Выводим приветствие и получаем имя игрока
        String playerName = greeting();

        // Получаем количество циклов игры
        int numberOfCycles = questionsAndAnswers.length;

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
            output("Question: " + questionsAndAnswers[counter][question] + "\n");

            // Выводим приглашение к вводу ответа
            output("Your answer: ");

            // Получаем ответ игрока
            String playerAnswer = input.nextLine();

            // Валидация ответа
            // Флаг правильного ответа
            isWin = playerAnswer.equals(questionsAndAnswers[counter][answer]);

            // Проверка ответа игрока
            if (isWin) {
                output("Correct!" + "\n");
            } else {
                output("'" + playerAnswer + "' is wrong answer ;(. Correct answer was '"
                        + questionsAndAnswers[counter][answer] + "'.\n");
                break;
            }

            ++counter;

        } while (counter < numberOfCycles);

        // Выводим итоговое сообщение
        String string = isWin ? "Congratulations, " + playerName + "!" : "Let's try again, " + playerName + "!";
        output(string);

    }

    // Вывод приветствия и получение имени игрока
    static String greeting() {
        String playerName;
        output("""
                \nWelcome to the Brain Games!
                May I have your name?\s""");
        playerName = inputString();
        output("Hello, " + playerName + "!");
        return playerName;
    }

    // Метод для вывода строки
    static void output(String string) {
        System.out.print(string);
    }

    // Метод для ввода строки
    static String inputString() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }
}
