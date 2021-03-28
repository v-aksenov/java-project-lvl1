package hexlet.code;

import java.util.Scanner;

public class Cli {

    private static final Scanner scanner = new Scanner(System.in);

    public static void inputName() {
        System.out.println("May I have your name?");
        String name = scanner.nextLine();
        System.out.printf("Hello, %s!", name);
    }
}
