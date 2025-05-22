package hexlet.code;
import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.Gcd;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

public class App {
    public static void main(String[] args) {
        // Выводим список игр
        Engine.output("""
                Please enter the game number and press Enter.
                1 - Greet
                2 - Even
                3 - Calc
                4 - GCD
                5 - Progression
                6 - Prime
                0 - Exit
                Your choice:\s""");
        // Получаем с клавиатуры номер из списка
        String itemNumber = Engine.inputString();

        switch (itemNumber) {
            case "0" -> Engine.output("Exit" + "\n");
            case "1" -> Engine.greeting();
            case "2" -> Even.generate();
            case "3" -> Calc.generate();
            case "4" -> Gcd.generate();
            case "5" -> Progression.generate();
            case "6" -> Prime.generate();
            default -> Engine.output("There is no such game." + "\n");
        }
    }

}
