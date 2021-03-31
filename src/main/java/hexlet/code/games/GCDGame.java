package hexlet.code.games;

public class GCDGame extends BasicGame {

    private Integer option1 = 0;
    private Integer option2 = 0;

    @Override
    protected final String getMessage() {
        return MESSAGE;
    }

    @Override
    protected final String getOption() {
        return "%s %s".formatted(option1, option2);
    }

    @Override
    public final void initState() {
        int multiplier = getRandomNonZero();
        int multiplierOption1 = getRandomNonZero();
        int multiplierOption2 = getRandomNonZero();
        option1 = multiplier * multiplierOption1;
        option2 = multiplier * multiplierOption2;
    }

    @Override
    public final String getCorrectAnswer() {
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
            "Find the greatest common divisor of given numbers.";
}
