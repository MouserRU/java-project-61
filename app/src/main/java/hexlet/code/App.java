package hexlet.code;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String playerName;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        playerName = scanner.nextLine();
        System.out.println("Hello, " + playerName + "!");
    }
}
