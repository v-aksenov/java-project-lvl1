package hexlet.code.games;

public class GCDGame extends BasicGame {

    private Integer option1 = 0;
    private Integer option2 = 0;


    @Override
    protected final String getMessage() {
        return String.format(MESSAGE, option1, option2);
    }

    @Override
    public final void initState() {
        int multiplier = RANDOM.nextInt(MAX_NUMBER);
        option1 = multiplier * RANDOM.nextInt(MAX_NUMBER);
        option2 = multiplier * RANDOM.nextInt(MAX_NUMBER);
    }

    @Override
    public final String initCorrectAnswer() {
        return getMultiplier().toString();
    }

    private Integer getMultiplier() {
        int gdcCandidate = option1;
        int b = option2;
        while (gdcCandidate != b) {
            if (gdcCandidate > b) {
                gdcCandidate -= b;
            } else {
                b -= gdcCandidate;
            }
        }
        return gdcCandidate;
    }

    private static final String MESSAGE =
            """
                    Find the greatest common divisor of given numbers.
                    Question: %s %s
                    Your answer:\s""";
}
