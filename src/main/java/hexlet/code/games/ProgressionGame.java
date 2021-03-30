package hexlet.code.games;

import java.util.ArrayList;
import java.util.List;

public class ProgressionGame extends BasicGame {

    private final List<String> progression = new ArrayList<>();

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
        progression.clear();
        int amount = RANDOM.nextInt(MAX_NUMBER) + MIN_PROGRESSION_SIZE;
        int currentElement = RANDOM.nextInt(MAX_NUMBER);
        int step = RANDOM.nextInt(MAX_NUMBER) + 1;
        for (int i = 0; i < amount; i++) {
            progression.add(Integer.toString(currentElement));
            currentElement += step;
        }
    }

    @Override
    public final String getCorrectAnswer() {
        int elementToHide = RANDOM.nextInt(progression.size());
        String hiddenElement = progression.get(elementToHide);
        progression.remove(elementToHide);
        progression.add(elementToHide, HIDDEN);
        return hiddenElement;
    }

    private static final int MIN_PROGRESSION_SIZE = 5;
    private static final String HIDDEN = "..";
    private static final String MESSAGE =
            "What number is missing in the progression?";
}
