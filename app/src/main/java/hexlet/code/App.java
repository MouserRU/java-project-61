package hexlet.code;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");
        Scanner scanner = new Scanner(System.in);
        String itemNumber = scanner.nextLine();

        if (itemNumber.equals("1")) {
            Cli.greeting();
        }
    }
}
