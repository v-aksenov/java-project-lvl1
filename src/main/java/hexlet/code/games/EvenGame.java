package hexlet.code.games;

import hexlet.code.commons.GameEngine;

import java.util.ArrayList;
import java.util.List;

import static hexlet.code.commons.Constants.GAME_ROUNDS;
import static hexlet.code.commons.Constants.NO;
import static hexlet.code.commons.Constants.YES;
import static hexlet.code.commons.Utils.getRandomNonZero;

public class EvenGame {

    public static void startGame(String name) {
        List<String> options = new ArrayList<>();
        List<String> answers = new ArrayList<>();
        for (int i = 0; i < GAME_ROUNDS; i++) {
            int option = getRandomNonZero();
            options.add(Integer.toString(option));
            answers.add(isEven(option) ? YES : NO);
        }
        GameEngine.playWithUser(START_MESSAGE, name, options, answers);
    }

    private static boolean isEven(int numberToCheck) {
        return numberToCheck % 2 == 0;
    }

    private static final String START_MESSAGE = "Answer 'yes' if number even otherwise answer 'no'.";
}
