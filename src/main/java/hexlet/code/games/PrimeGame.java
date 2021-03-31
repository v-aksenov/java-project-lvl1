package hexlet.code.games;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeGame extends BasicGame {

    private final List<Integer> allNumbers = IntStream
            .range(0, BOUND)
            .boxed()
            .collect(Collectors.toList());
    private final List<String> primeNumbers = initPrimeNumbers();
    private String primeOption;

    @Override
    protected final String getMessage() {
        return MESSAGE;
    }

    @Override
    protected final String getOption() {
        return primeOption;
    }

    @Override
    public final void initState() {
        int primeOptionIndex = RANDOM.nextInt(allNumbers.size());
        primeOption = allNumbers.get(primeOptionIndex).toString();
    }

    @Override
    public final String getCorrectAnswer() {
        return primeNumbers.contains(primeOption) ? YES : NO;
    }


    private List<String> initPrimeNumbers() {
        List<Integer> numbers = new ArrayList<>(allNumbers);
        int i = 2;
        while (i < numbers.size()) {
            if (!numbers.get(i).equals(0)) {
                int j = i + i;
                while (j < numbers.size()) {
                    numbers.set(j, 0);
                    j += i;
                }
            }
            i++;
        }
        return numbers.stream()
                .filter(n -> !n.equals(0))
                .map(Object::toString)
                .collect(Collectors.toList());
    }

    public static final String YES = "yes";
    public static final String NO = "no";
    private static final Integer BOUND = 200;
    private static final String MESSAGE =
            "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
}
