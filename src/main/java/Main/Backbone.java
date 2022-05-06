package Main;

import java.util.Scanner;

public class Backbone {
    static Scanner scanner = new Scanner(System.in);

    public static int readInt(int userChoices) {
        int input = 0;
        String prompt = "-> ";

        do {
            System.out.print(prompt);
            try {
                input = Integer.parseInt(scanner.next());

            } catch (Exception e) {
                System.out.println("Invalid Choice!");
            }

        } while (input < 1 || input > userChoices);
        return input;

    }

    public static String readStr(String userChoices) {
        String prompt = "-> ";
        System.out.print(prompt);
        String input = scanner.next().toUpperCase();
        return input;
    }

    public static void clearConsole() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

    public static void printSeparator(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("-");

        }
        System.out.println();
    }

    public static void printHeading(String heading) {
        printSeparator(30);
        System.out.println(heading);
        printSeparator(30);
    }

    public static void anythingToContinue() {
        System.out.println("\nEnter anything to continue.");
        scanner.nextLine();
        scanner.nextLine();
    }

    public static void timePass(){
        for(int i = 0; i < 3; i++){
            System.out.println("\n\n\n...");
        }
        System.out.println("\n\n\n\n");
    }
}
