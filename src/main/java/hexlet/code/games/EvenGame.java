package hexlet.code.games;

public class EvenGame extends BasicGame {

    private Integer numberToUser;

    @Override
    protected final String getMessage() {
        return START_MESSAGE;
    }

    @Override
    protected final String getOption() {
        return numberToUser.toString();
    }

    public final void initState() {
        numberToUser = RANDOM.nextInt(MAX_NUMBER) + 1;
    }

    @Override
    public final String getCorrectAnswer() {
        return numberToUser % 2 == 0 ? NO : YES;
    }

    public static final String YES = "yes";
    public static final String NO = "no";
    public static final String START_MESSAGE =
            "Answer 'yes' if number even otherwise answer 'no'.";
}
