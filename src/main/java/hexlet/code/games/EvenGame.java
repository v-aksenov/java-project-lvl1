package hexlet.code.games;

import static hexlet.code.games.engine.Commons.GAME_COUNT;
import static hexlet.code.games.engine.Commons.NO;
import static hexlet.code.games.engine.Commons.YES;
import static hexlet.code.games.engine.Commons.gameLoop;
import static hexlet.code.games.engine.Commons.getRandomNonZero;
import static hexlet.code.games.engine.Commons.printCongratulations;

public class EvenGame {

    public static void startGame(final String name) {
        System.out.println(START_MESSAGE);
        boolean success = true;
        int i = 0;
        int option;
        String correctAnswer;
        while (i++ < GAME_COUNT && success) {
            option = getRandomNonZero();
            correctAnswer = getCorrectAnswer(option);
            success = gameLoop(name, Integer.toString(option), correctAnswer);
        }
        if (success) {
            printCongratulations(name);
        }
    }

    public static String getCorrectAnswer(final int option) {
        return option % 2 == 0 ? YES : NO;
    }

    private static final String START_MESSAGE =
            "Answer 'yes' if number even otherwise answer 'no'.";
}
