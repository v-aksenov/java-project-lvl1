package hexlet.code;

public class EvenGame implements Game {

    private int numberToUser;
    private boolean isEven;
    private String input;

    public final void startGame(final String name) {
        boolean finished = gameLoop();
        while (!finished) {
            System.out.printf(INCORRECT, input, isEven ? YES : NO, name);
            finished = gameLoop();
        }
        System.out.println(CORRECT);
    }

    public boolean gameLoop() {
        initState();
        System.out.printf(START_MESSAGE, numberToUser);
        input = scanner.nextLine();
        return YES.equals(input) && isEven || NO.equals(input) && !isEven;
    }

    public void initState() {
        numberToUser = random.nextInt(MAX_NUMBER) + 1;
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
