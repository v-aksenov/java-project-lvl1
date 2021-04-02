package hexlet.code.commons;

import java.util.List;
import java.util.Scanner;

import static hexlet.code.commons.Constants.CONGRATULATIONS;
import static hexlet.code.commons.Constants.CORRECT;
import static hexlet.code.commons.Constants.GAME_ROUNDS;
import static hexlet.code.commons.Constants.INCORRECT;
import static hexlet.code.commons.Constants.QUESTION;

public class GameEngine {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void playWithUser(String rules, String name, List<String> options, List<String> answers) {
        validateGameData(rules, name, options, answers);
        printRules(rules);
        boolean success = true;
        int i = 0;
        while (i < GAME_ROUNDS && success) {
            success = runRound(name, options.get(i), answers.get(i));
            i++;
        }
        if (success) {
            printCongratulations(name);
        }
    }

    private static void validateGameData(String rules, String name, List<String> options, List<String> answers) {
        if (rules == null || rules.isBlank()) {
            throw new IllegalArgumentException("required field 'rules'");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("required field 'name'");
        }
        if (options.size() != answers.size() && options.size() < GAME_ROUNDS) {
            throw new IllegalArgumentException("Wrong size of options/answers lists");
        }
    }

    private static boolean runRound(String name, String question, String correctAnswer) {
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

    private static void printCorrect() {
        System.out.println(CORRECT);
    }

    private static void printCongratulations(String name) {
        System.out.printf(CONGRATULATIONS, name);
    }

    private static void printRules(String rules) {
        System.out.println(rules);
    }

    private static void printIncorrect(String name, String currentInput, String expectedInput) {
        System.out.printf(INCORRECT, currentInput, expectedInput, name);
    }
}
