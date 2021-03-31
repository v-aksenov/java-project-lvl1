package hexlet.code.games;

public abstract class BasicGame implements Game {

    private String userInput = "";

    protected abstract String getMessage();

    protected abstract String getOption();

    @Override
    public final boolean gameLoop() {
        initState();
        System.out.println(QUESTION + getOption());
        System.out.println(YOUR_ANSWER);
        userInput = SCANNER.nextLine();
        return getCorrectAnswer().equals(userInput);
    }

    @Override
    public final void startGame(final String name) {
        boolean success = true;
        int i = 0;
        System.out.println(getMessage());
        while (i++ < GAME_COUNT && success) {
            success = gameLoop();
            if (success) {
                System.out.println(CORRECT);
            } else {
                System.out.printf(
                        INCORRECT,
                        userInput,
                        getCorrectAnswer(),
                        name
                );
            }
        }
        if (success) {
            System.out.printf(CONGRATULATIONS, name);
        }
    }

    @Override
    public abstract void initState();

    public abstract String getCorrectAnswer();

    protected final Integer getRandomNonZero() {
        return RANDOM.nextInt(MAX_NUMBER) + 1;
    }
}
