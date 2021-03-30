package hexlet.code.games;

public class EvenGame extends BasicGame {

    private int numberToUser;

    @Override
    protected final String getMessage() {
        return String.format(START_MESSAGE, numberToUser);
    }

    public final void initState() {
        numberToUser = RANDOM.nextInt(MAX_NUMBER) + 1;
    }

    @Override
    public final String initCorrectAnswer() {
        return numberToUser % 2 == 0 ? YES : NO;
    }

    public static final String YES = "yes";
    public static final String NO = "no";
    public static final String START_MESSAGE = """
            Answer 'yes' if number even otherwise answer 'no'.
            Question: %s
            Your answer: """;

}
