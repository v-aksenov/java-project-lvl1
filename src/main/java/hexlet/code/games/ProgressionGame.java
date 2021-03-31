package hexlet.code.games;

import java.util.ArrayList;
import java.util.List;

public class ProgressionGame extends BasicGame {

    private final List<String> progression = new ArrayList<>();
    private String hiddenElement;

    @Override
    protected final String getMessage() {
        return MESSAGE;
    }

    @Override
    protected final String getOption() {
        return String.join(" ", progression);
    }

    @Override
    public final void initState() {
        initProgression();
        hideElement();
    }

    private void initProgression() {
        progression.clear();
        int amount = RANDOM.nextInt(MAX_NUMBER) + MIN_PROGRESSION_SIZE;
        int currentElement = getRandomNonZero();
        int step = getRandomNonZero();
        for (int i = 0; i < amount; i++) {
            progression.add(Integer.toString(currentElement));
            currentElement += step;
        }
    }

    private void hideElement() {
        int elementToHide = RANDOM.nextInt(progression.size());
        hiddenElement = progression.get(elementToHide);
        progression.remove(elementToHide);
        progression.add(elementToHide, HIDDEN);
    }

    @Override
    public final String getCorrectAnswer() {
        return hiddenElement;
    }

    private static final int MIN_PROGRESSION_SIZE = 5;
    private static final String HIDDEN = "..";
    private static final String MESSAGE =
            "What number is missing in the progression?";
}
