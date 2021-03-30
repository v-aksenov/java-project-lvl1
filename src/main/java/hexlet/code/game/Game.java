package hexlet.code.game;

import java.util.Random;
import java.util.Scanner;

public interface Game {
    Random RANDOM = new Random();
    Scanner SCANNER = new Scanner(System.in);

    boolean gameLoop();

    void startGame(String name);

    void initState();

    int MAX_NUMBER = 10;

    String CORRECT = "Correct!";
    String INCORRECT = "'%s' is wrong answer ;(. "
            + "Correct answer was '%s'.\n"
            + "Let's try again, %s!";

    int GAME_COUNT = 3;
}
