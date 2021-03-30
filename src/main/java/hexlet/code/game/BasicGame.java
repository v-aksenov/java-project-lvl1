package hexlet.code.game;

public abstract class BasicGame implements Game {

    private String userInput = "";
    private String correctAnswer;

    protected abstract String getMessage();

    @Override
    public final boolean gameLoop() {
        initState();
        correctAnswer = initCorrectAnswer();
        System.out.print(getMessage());
        userInput = SCANNER.nextLine();
        return isCorrect();
    }

    @Override
    public final void startGame(final String name) {
        boolean success;
        for (int i = 0; i < GAME_COUNT; i++) {
            success = gameLoop();
            if (success) {
                System.out.println(CORRECT);
            } else {
                System.out.printf(INCORRECT, userInput, correctAnswer, name);
            }
        }
        System.out.printf(CONGRATULATIONS, name);
    }

    protected final boolean isCorrect() {
        return correctAnswer.equals(userInput);
    }

    @Override
    public abstract void initState();
    public abstract String initCorrectAnswer();
}
