package hexlet.code;

import java.util.Scanner;

public class Cli {
    static void greeting() {
        String playerName;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        playerName = scanner.nextLine();
        System.out.println("Hello, " + playerName + "!");
    }
}
