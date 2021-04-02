package hexlet.code.games;

import hexlet.code.commons.GameEngine;

import java.util.ArrayList;
import java.util.List;

import static hexlet.code.commons.Constants.GAME_ROUNDS;
import static hexlet.code.commons.Utils.RANDOM;
import static hexlet.code.commons.Utils.getRandomNonZero;

public class ProgressionGame {

    public static void startGame(String name) {
        List<String> options = new ArrayList<>();
        List<String> answers = new ArrayList<>();
        for (int i = 0; i < GAME_ROUNDS; i++) {
            List<String> progression = generateProgression();
            int elementToHide = chooseElementToHide(progression);
            String hiddenElement = progression.get(elementToHide);
            options.add(getQuestion(progression, elementToHide));
            answers.add(hiddenElement);
        }
        GameEngine.playWithUser(START_MESSAGE, name, options, answers);
    }

    protected static String getQuestion(List<String> progression, int elementToHide) {
        progression.remove(elementToHide);
        progression.add(elementToHide, HIDDEN);
        return String.join(" ", progression);
    }

    private static List<String> generateProgression() {
        List<String> progression = new ArrayList<>();
        int amount = getRandomNonZero() + ProgressionGame.MIN_PROGRESSION_SIZE;
        int currentElement = getRandomNonZero();
        int step = getRandomNonZero();
        for (int i = 0; i < amount; i++) {
            progression.add(Integer.toString(currentElement));
            currentElement += step;
        }
        return progression;
    }

    private static int chooseElementToHide(final List<String> progression) {
        return RANDOM.nextInt(progression.size());
    }

    private static final int MIN_PROGRESSION_SIZE = 5;
    private static final String HIDDEN = "..";
    private static final String START_MESSAGE = "What number is missing in the progression?";
}
