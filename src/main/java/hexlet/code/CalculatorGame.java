package hexlet.code;

import java.util.List;

public class CalculatorGame implements Game {

    private Integer a = 0;
    private Integer b = 0;
    private Integer action = 0;
    private Integer result = 0;

    private String input = "";

    @Override
    public boolean gameLoop() {
        initState();
        System.out.printf((QUESTION) + "%n", a, ACTIONS.get(action), b);
        input = scanner.nextLine();
        try {
            return result.equals(Integer.valueOf(input));
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public void startGame(String name) {
        boolean success;
        for (int i = 0; i < GAME_COUNT; i++) {
            success = gameLoop();
            if(success) {
                System.out.println(CORRECT);
            } else {
                System.out.printf(INCORRECT, input, result, name);
            }
        }
    }

    @Override
    public void initState() {
        a = random.nextInt(MAX_NUMBER);
        b = random.nextInt(MAX_NUMBER);
        action = random.nextInt(ACTIONS.size());
        result = doAction();
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

    public static final int MAX_NUMBER = 20;
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
