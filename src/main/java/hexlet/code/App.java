package hexlet.code;

import java.util.Scanner;

public class App {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static String name;

    public static void main(final String[] args) {
        String game = chooseGame();
        if (GREET_GAME.equals(game)) {
            name = greetings();
            new EvenGame().startGame(name);
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

    public static final String GREET_GAME = "1";

    public static final String CHOOSE_GAME =
            """
                    Please enter the game number and press Enter.
                    1 - Greet
                    0 - Exit
                    Your choice: """;
}
