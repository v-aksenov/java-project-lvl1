package hexlet.code.games;

import hexlet.code.commons.GameEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static hexlet.code.commons.Constants.GAME_ROUNDS;
import static hexlet.code.commons.Constants.MAX_NUMBER;

public class CalculatorGame {

    private static final Random RANDOM = new Random();

    public static void startGame(String name) {
        List<String> options = new ArrayList<>();
        List<String> answers = new ArrayList<>();
        for (int i = 0; i < GAME_ROUNDS; i++) {
            int a = RANDOM.nextInt(MAX_NUMBER);
            int b = RANDOM.nextInt(MAX_NUMBER);
            int actionIndex = RANDOM.nextInt(ACTIONS.size());
            String action = ACTIONS.get(actionIndex);
            options.add(OPTION_MESSAGE.formatted(a, action, b));
            answers.add(Integer.toString(getExpressionResult(a, b, action)));
        }
        GameEngine.playWithUser(START_MESSAGE, name, options, answers);
    }

    private static int getExpressionResult(int a, int b, String action) {
        switch (action) {
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

    private static final String OPTION_MESSAGE = "%s %s %s";
    private static final String START_MESSAGE = "What is the result of the expression?";
}
