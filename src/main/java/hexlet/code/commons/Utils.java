package hexlet.code.commons;

import java.util.Random;

import static hexlet.code.commons.Constants.MAX_NUMBER;

public class Utils {

    public static final Random RANDOM = new Random();

    public static Integer getRandomNonZero() {
        return RANDOM.nextInt(MAX_NUMBER) + 1;
    }

}
