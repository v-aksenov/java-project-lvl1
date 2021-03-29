package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public interface Game {
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);

    boolean gameLoop();

    void startGame(final String name);

    void initState();

    String CORRECT = "Correct!";
    String INCORRECT = "'%s' is wrong answer ;(. "
            + "Correct answer was '%s'.\n"
            + "Let's try again, %s!";
}
