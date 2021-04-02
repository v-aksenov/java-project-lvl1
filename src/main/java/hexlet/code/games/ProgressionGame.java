package hexlet.code.games;

import java.util.ArrayList;
import java.util.List;

import static hexlet.code.commons.EngineUtils.RANDOM;
import static hexlet.code.commons.EngineUtils.gameLoop;
import static hexlet.code.commons.EngineUtils.getRandomNonZero;
import static hexlet.code.commons.EngineUtils.printCongratulations;
import static hexlet.code.commons.Constants.GAME_COUNT;
import static hexlet.code.commons.Constants.MAX_NUMBER;

public class ProgressionGame {

    public static void startGame(final String name) {
        System.out.println(START_MESSAGE);
        boolean success = true;
        int i = 0;
        List<String> progression;
        int hiddenElementIndex;
        String hiddenElement;
        while (i++ < GAME_COUNT && success) {
            progression = initProgression();
            hiddenElementIndex = chooseElementToHide(progression);
            hiddenElement = progression.get(hiddenElementIndex);
            success = gameLoop(
                    name,
                    getQuestion(progression, hiddenElementIndex),
                    hiddenElement
            );
        }
        if (success) {
            printCongratulations(name);
        }
    }

    protected static String getQuestion(
            final List<String> progression,
            final int elementToHide
    ) {
        progression.remove(elementToHide);
        progression.add(elementToHide, HIDDEN);
        return String.join(" ", progression);
    }

    private static List<String> initProgression() {
        List<String> progression = new ArrayList<>();
        int amount = RANDOM.nextInt(MAX_NUMBER) + MIN_PROGRESSION_SIZE;
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
    private static final String START_MESSAGE =
            "What number is missing in the progression?";
}
