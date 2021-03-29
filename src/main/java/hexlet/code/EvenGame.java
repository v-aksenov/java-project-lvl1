package hexlet.code;

public class EvenGame implements Game {

    private int numberToUser;
    private boolean isEven;
    private String input;

    public final void startGame(final String name) {
        boolean success;
        for (int i = 0; i < GAME_COUNT; i++) {
            success = gameLoop();
            if (success) {
                System.out.println(CORRECT);
            } else {
                System.out.printf(INCORRECT, input, isEven ? YES : NO, name);
            }
        }
    }

    public final boolean gameLoop() {
        initState();
        System.out.printf(START_MESSAGE, numberToUser);
        input = SCANNER.nextLine();
        return YES.equals(input) && isEven || NO.equals(input) && !isEven;
    }

    public final void initState() {
        numberToUser = RANDOM.nextInt(MAX_NUMBER) + 1;
        isEven = numberToUser % 2 == 0;
    }

    private static final int MAX_NUMBER = 20;
    public static final String YES = "yes";
    public static final String NO = "no";
    public static final String START_MESSAGE = """
            Answer 'yes' if number even otherwise answer 'no'.
            Question: %s
            Your answer: """;

}
