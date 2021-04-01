package hexlet.code.games.engine;

import java.util.Random;
import java.util.Scanner;

public class Commons {
    public static final Random RANDOM = new Random();
    public static final Scanner SCANNER = new Scanner(System.in);

    public static final int MAX_NUMBER = 10;
    public static final String YES = "yes";
    public static final String NO = "no";
    public static final String CORRECT = "Correct!";
    public static final String INCORRECT = """
            '%s' is wrong answer ;(. Correct answer was '%s'.
            Let's try again, %s!
            """;
    public static final String CONGRATULATIONS = "Congratulations, %s!";
    public static final String QUESTION = "Question: %s\nYour answer: ";
    public static final int GAME_COUNT = 3;

    public static Integer getRandomNonZero() {
        return RANDOM.nextInt(MAX_NUMBER) + 1;
    }

    public static void printCorrect() {
        System.out.println(CORRECT);
    }

    public static void printCongratulations(final String name) {
        System.out.printf(CONGRATULATIONS, name);
    }

    public static void printIncorrect(
            final String name,
            final String currentInput,
            final String expectedInput
    ) {
        System.out.printf(INCORRECT, currentInput, expectedInput, name);
    }

    public static boolean gameLoop(
            final String name,
            final String question,
            final String correctAnswer
    ) {
        System.out.printf(QUESTION, question);
        String userInput = SCANNER.nextLine();
        boolean isCorrect = correctAnswer.equals(userInput);
        if (isCorrect) {
            printCorrect();
        } else {
            printIncorrect(name, userInput, correctAnswer);
        }
        return isCorrect;
    }

}
