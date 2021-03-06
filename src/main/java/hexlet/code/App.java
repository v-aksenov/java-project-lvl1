package hexlet.code;

import hexlet.code.games.CalculatorGame;
import hexlet.code.games.EvenGame;
import hexlet.code.games.GCDGame;
import hexlet.code.games.PrimeGame;
import hexlet.code.games.ProgressionGame;

import java.util.Scanner;

public class App {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(final String[] args) {
        String game = chooseGame();
        switch (game) {
            case GREET_CODE -> greetings();
            case EVEN_CODE -> EvenGame.startGame(greetings());
            case CALC_CODE -> CalculatorGame.startGame(greetings());
            case GCD_CODE -> GCDGame.startGame(greetings());
            case PROGRESSION_CODE -> ProgressionGame.startGame(greetings());
            case PRIME_CODE -> PrimeGame.startGame(greetings());
            default -> System.out.println("unknown code");
        }
    }

    private static String chooseGame() {
        System.out.print(CHOOSE_GAME);
        return SCANNER.nextLine();
    }

    private static String greetings() {
        System.out.println("Welcome to the Brain Games!");
        return Cli.inputName();
    }

    public static final String GREET_CODE = "1";
    public static final String EVEN_CODE = "2";
    public static final String CALC_CODE = "3";
    public static final String GCD_CODE = "4";
    public static final String PROGRESSION_CODE = "5";
    public static final String PRIME_CODE = "6";
    public static final String EXIT_CODE = "0";

    public static final String CHOOSE_GAME =
            "Please enter the game number and press Enter.\n"
                    + GREET_CODE + " - Greet\n"
                    + EVEN_CODE + " - Even\n"
                    + CALC_CODE + " - Calc\n"
                    + GCD_CODE + " - GCD\n"
                    + PROGRESSION_CODE + " - Progression\n"
                    + PRIME_CODE + " - Prime\n"
                    + EXIT_CODE + " - Exit\n"
                    + "Your choice: ";
}
