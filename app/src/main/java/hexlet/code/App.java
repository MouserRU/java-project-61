package hexlet.code;
import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.Gcd;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Выводим список игр
        System.out.print("Please enter the game number and press Enter.\n"
                + "1 - Greet\n"
                + "2 - Even\n"
                + "3 - Calc\n"
                + "4 - GCD\n"
                + "5 - Progression\n"
                + "6 - Prime\n"
                + "0 - Exit\n"
                + "Your choice: ");

        // Получаем с клавиатуры номер из списка
        String itemNumber = input.nextLine();

        switch (itemNumber) {
            case "0" -> System.out.print("Exit.");
            case "1" -> Cli.greeting();
            case "2" -> Even.generate();
            case "3" -> Calc.generate();
            case "4" -> Gcd.generate();
            case "5" -> Progression.generate();
            case "6" -> Prime.generate();
            default -> System.out.println("There is no such game." + "\n");
        }
    }

}
