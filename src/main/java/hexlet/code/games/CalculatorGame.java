package hexlet.code.games;

import java.util.List;

import static hexlet.code.games.engine.Commons.GAME_COUNT;
import static hexlet.code.games.engine.Commons.MAX_NUMBER;
import static hexlet.code.games.engine.Commons.RANDOM;
import static hexlet.code.games.engine.Commons.gameLoop;
import static hexlet.code.games.engine.Commons.printCongratulations;

public class CalculatorGame {

    public static void startGame(final String name) {
        System.out.println(START_MESSAGE);
        boolean success = true;
        int i = 0;
        String option;
        int a;
        int b;
        int actionIndex;
        String correctAnswer;
        while (i++ < GAME_COUNT && success) {
            a = RANDOM.nextInt(MAX_NUMBER);
            b = RANDOM.nextInt(MAX_NUMBER);
            actionIndex = RANDOM.nextInt(ACTIONS.size());
            option = getOption(a, b, actionIndex);
            correctAnswer = Integer
                    .toString(getExpressionResult(a, b, actionIndex));
            success = gameLoop(name, option, correctAnswer);
        }
        if (success) {
            printCongratulations(name);
        }
    }

    protected static String getOption(
            final int a,
            final int b,
            final int actionIndex
    ) {
        return "%s %s %s".formatted(a, ACTIONS.get(actionIndex), b);
    }

    private static int getExpressionResult(
            final int a,
            final int b,
            final int actionIndex
    ) {
        switch (ACTIONS.get(actionIndex)) {
            case PLUS -> {
                return a + b;
            }
            case MINUS -> {
                return a - b;
            }
            case MULTI -> {
                return a * b;
            }
            default -> throw new IllegalStateException();
        }
    }

    public static final String PLUS = "+";
    public static final String MINUS = "-";
    public static final String MULTI = "*";
    private static final List<String> ACTIONS = List.of(PLUS, MINUS, MULTI);

    private static final String START_MESSAGE =
            "What is the result of the expression?";
}
