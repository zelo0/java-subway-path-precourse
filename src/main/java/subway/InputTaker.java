package subway;

import java.util.Scanner;

public class InputTaker {

    private final Scanner scanner;

    public InputTaker(Scanner scanner) {
        this.scanner = scanner;
    }

    public String takeInput(String message) {
        System.out.println("\n" + message);
        return scanner.nextLine();
    }
}
