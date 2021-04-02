package hexlet.code.commons;

import java.util.Random;
import java.util.Scanner;

import static hexlet.code.commons.Constants.CONGRATULATIONS;
import static hexlet.code.commons.Constants.CORRECT;
import static hexlet.code.commons.Constants.INCORRECT;
import static hexlet.code.commons.Constants.MAX_NUMBER;
import static hexlet.code.commons.Constants.QUESTION;

public class EngineUtils {
    public static final Random RANDOM = new Random();
    public static final Scanner SCANNER = new Scanner(System.in);

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
