package hexlet.code.games;

import hexlet.code.commons.GameEngine;

import java.util.ArrayList;
import java.util.List;

import static hexlet.code.commons.Constants.GAME_ROUNDS;
import static hexlet.code.commons.Utils.getRandomNonZero;

public class GCDGame {

    public static void startGame(String name) {
        List<String> options = new ArrayList<>();
        List<String> answers = new ArrayList<>();
        for (int i = 0; i < GAME_ROUNDS; i++) {
            int multiplier = getRandomNonZero();
            int option1 = multiplier * getRandomNonZero();
            int option2 = multiplier * getRandomNonZero();
            int correctAnswer = getGcd(option1, option2);
            options.add(OPTION_MESSAGE.formatted(option1, option2));
            answers.add(Integer.toString(correctAnswer));
        }
        GameEngine.playWithUser(START_MESSAGE, name, options, answers);
    }

    private static int getGcd(int option1, int option2) {
        int gdcCandidate = option1;
        int b = option2;
        while (gdcCandidate != b) {
            if (gdcCandidate > b) {
                gdcCandidate -= b;
            } else {
                b -= gdcCandidate;
            }
        }
        return gdcCandidate;
    }

    private static final String OPTION_MESSAGE = "%s %s";
    private static final String START_MESSAGE = "Find the greatest common divisor of given numbers.";
}
