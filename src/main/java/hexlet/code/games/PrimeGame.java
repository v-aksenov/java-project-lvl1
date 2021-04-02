package hexlet.code.games;

import java.util.ArrayList;
import java.util.List;

import static hexlet.code.commons.EngineUtils.RANDOM;
import static hexlet.code.commons.EngineUtils.gameLoop;
import static hexlet.code.commons.EngineUtils.printCongratulations;
import static hexlet.code.commons.Constants.GAME_COUNT;
import static hexlet.code.commons.Constants.NO;
import static hexlet.code.commons.Constants.YES;

public class PrimeGame {

    public static void startGame(final String name) {
        System.out.println(START_MESSAGE);
        boolean success = true;
        int i = 0;
        List<String> allNumbers = initAllNumbers();
        List<String> primeNumbers = initPrimeNumbers(allNumbers);
        String optionElement;
        String correctAnswer;
        while (i++ < GAME_COUNT && success) {
            optionElement = allNumbers.get(RANDOM.nextInt(allNumbers.size()));
            correctAnswer = primeNumbers.contains(optionElement) ? YES : NO;
            success = gameLoop(name, optionElement, correctAnswer);
        }
        if (success) {
            printCongratulations(name);
        }
    }

    private static List<String> initAllNumbers() {
        List<String> numbers = new ArrayList<>();
        for (int i = 0; i < BOUND; i++) {
            numbers.add(Integer.toString(i));
        }
        return numbers;
    }

    private static List<String> initPrimeNumbers(
            final List<String> allNumbers
    ) {
        List<String> numbers = new ArrayList<>(allNumbers);
        int i = 2;
        while (i < numbers.size()) {
            if (numbers.get(i) != null) {
                int j = i + i;
                while (j < numbers.size()) {
                    numbers.set(j, null);
                    j += i;
                }
            }
            i++;
        }
        numbers.remove(0);
        numbers.remove(0);
        return withoutNull(numbers);
    }

    private static List<String> withoutNull(final List<String> array) {
        List<String> nonNulls = new ArrayList<>();
        for (String element : array) {
            if (element != null) {
                nonNulls.add(element);
            }
        }
        return nonNulls;
    }

    private static final Integer BOUND = 200;
    private static final String START_MESSAGE =
            "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
}
