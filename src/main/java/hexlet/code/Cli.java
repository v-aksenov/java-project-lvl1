package hexlet.code;

import java.util.Scanner;

public class Cli {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static String inputName() {
        System.out.println("May I have your name?");
        String name = SCANNER.nextLine();
        System.out.printf("Hello, %s!", name);
        return name;
    }
}
