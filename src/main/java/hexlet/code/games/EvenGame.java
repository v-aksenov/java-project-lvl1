package hexlet.code.games;

import static hexlet.code.commons.EngineUtils.gameLoop;
import static hexlet.code.commons.EngineUtils.getRandomNonZero;
import static hexlet.code.commons.EngineUtils.printCongratulations;
import static hexlet.code.commons.Constants.GAME_COUNT;
import static hexlet.code.commons.Constants.NO;
import static hexlet.code.commons.Constants.YES;

public class EvenGame {

    public static void startGame(final String name) {
        System.out.println(START_MESSAGE);
        boolean success = true;
        int i = 0;
        int option;
        String correctAnswer;
        while (i++ < GAME_COUNT && success) {
            option = getRandomNonZero();
            correctAnswer = isEven(option) ? YES : NO;
            success = gameLoop(name, Integer.toString(option), correctAnswer);
        }
        if (success) {
            printCongratulations(name);
        }
    }

    private static boolean isEven(int numberToCheck) {
        return numberToCheck % 2 == 0;
    }

    private static final String START_MESSAGE =
            "Answer 'yes' if number even otherwise answer 'no'.";
}
