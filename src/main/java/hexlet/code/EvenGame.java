package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class EvenGame {

    private final Random random = new Random();
    private final Scanner scanner = new Scanner(System.in);

    private int numberToUser;
    private boolean isEven;
    private String input;

    public void startGame(String name) {
        boolean finished = gameLoop();
        while (!finished) {
            System.out.printf(INCORRECT, input, isEven ? YES : NO, name);
            finished = gameLoop();
        }
        System.out.println(CORRECT);
    }

    private boolean gameLoop() {
        initState();
        System.out.printf(START_MESSAGE, numberToUser);
        input = scanner.nextLine();
        return YES.equals(input) && isEven || NO.equals(input) && !isEven;
    }

    private void initState() {
        numberToUser = random.nextInt(20) + 1;
        isEven = numberToUser % 2 == 0;
    }

    public static final String YES = "yes";
    public static final String NO = "no";
    public static final String START_MESSAGE = """
            Answer 'yes' if number even otherwise answer 'no'.
            Question: %s
            Your answer: """;
    public static final String CORRECT = "Correct!";
    public static final String INCORRECT = "'%s' is wrong answer ;(. Correct answer was '%s'.\n" +
            "Let's try again, %s!";
}
