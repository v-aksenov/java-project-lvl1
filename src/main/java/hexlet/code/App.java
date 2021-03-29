package hexlet.code;

import java.util.Scanner;

public class App {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static String name;

    public static void main(final String[] args) {
        String game = chooseGame();
        switch (game) {
            case GREET_CODE -> greetingAction();
            case EVEN_CODE -> evenGameAction();
            default -> System.out.println("unknown code");
        }
    }

    private static void greetingAction() {
        name = greetings();
    }

    private static void evenGameAction() {
        greetingAction();
        new EvenGame().startGame(name);
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
    public static final String EXIT_CODE = "0";

    public static final String CHOOSE_GAME =
            "Please enter the game number and press Enter.\n"
                    + GREET_CODE + " - Greet\n"
                    + EVEN_CODE + " - Even\n"
                    + EXIT_CODE + " - Exit\n"
                    + "Your choice: ";
}
