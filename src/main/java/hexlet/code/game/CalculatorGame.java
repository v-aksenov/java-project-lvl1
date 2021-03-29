package hexlet.code.game;

import java.util.List;

public class CalculatorGame extends BasicGame {

    private Integer a = 0;
    private Integer b = 0;
    private Integer action = 0;

    @Override
    protected final String getMessage() {
        return String.format((QUESTION) + "%n", a, ACTIONS.get(action), b);
    }

    @Override
    public final void initOptions() {
        a = RANDOM.nextInt(MAX_NUMBER);
        b = RANDOM.nextInt(MAX_NUMBER);
        action = RANDOM.nextInt(ACTIONS.size());
    }

    @Override
    public final String initCorrectAnswer() {
        return doAction().toString();
    }

    private Integer doAction() {
        switch (ACTIONS.get(action)) {
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

    public static final String QUESTION =
            """
                    What is the result of the expression?
                    Question: %s %s %s
                    Your answer:\s""";
}
