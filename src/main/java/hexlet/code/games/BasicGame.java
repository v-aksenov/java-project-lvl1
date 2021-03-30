package hexlet.code.games;

public abstract class BasicGame implements Game {

    private String userInput = "";

    protected abstract String getMessage();

    protected abstract String getOption();

    @Override
    public final boolean gameLoop() {
        initState();
        System.out.println(getMessage());
        System.out.println(QUESTION + getOption());
        System.out.print(YOUR_ANSWER);
        userInput = SCANNER.nextLine();
        return getCorrectAnswer().equals(userInput);
    }

    @Override
    public final void startGame(final String name) {
        boolean success;
        for (int i = 0; i < GAME_COUNT; i++) {
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
        System.out.printf(CONGRATULATIONS, name);
    }

    @Override
    public abstract void initState();

    public abstract String getCorrectAnswer();
}
