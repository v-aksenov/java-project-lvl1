package hexlet.code.games;

import static hexlet.code.games.engine.Commons.GAME_COUNT;
import static hexlet.code.games.engine.Commons.gameLoop;
import static hexlet.code.games.engine.Commons.getRandomNonZero;
import static hexlet.code.games.engine.Commons.printCongratulations;

public class GCDGame {

    public static void startGame(final String name) {
        System.out.println(START_MESSAGE);
        boolean success = true;
        int i = 0;
        int option1;
        int option2;
        int multiplier;
        String correctAnswer;
        while (i++ < GAME_COUNT && success) {
            multiplier = getRandomNonZero();
            option1 = multiplier * getRandomNonZero();
            option2 = multiplier * getRandomNonZero();
            correctAnswer = getMultiplier(option1, option2);
            success = gameLoop(
                    name,
                    getQuestion(option1, option2),
                    correctAnswer
            );
        }
        if (success) {
            printCongratulations(name);
        }
    }

    protected static String getQuestion(
            final int option1,
            final int option2
    ) {
        return "%s %s".formatted(option1, option2);
    }

    private static String getMultiplier(
            final int option1,
            final int option2
    ) {
        int gdcCandidate = option1;
        int b = option2;
        while (gdcCandidate != b) {
            if (gdcCandidate > b) {
                gdcCandidate -= b;
            } else {
                b -= gdcCandidate;
            }
        }
        return Integer.toString(gdcCandidate);
    }

    private static final String START_MESSAGE =
            "Find the greatest common divisor of given numbers.";
}
