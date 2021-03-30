package hexlet.code.games;

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
    String INCORRECT = """
            '%s' is wrong answer ;(. Correct answer was '%s'.
            Let's try again, %s!
            """;
    String CONGRATULATIONS = "Congratulations, %s!";
    String YOUR_ANSWER = "Your answer: ";
    String QUESTION = "Question: ";

    int GAME_COUNT = 3;
}
