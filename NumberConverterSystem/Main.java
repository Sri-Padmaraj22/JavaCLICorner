import java.util.Scanner;

import Controllers.AuthController;
import Controllers.ConverterController;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        showMainMenu();

        System.out.println("Welcome to Number Converter System!!!");

        while (true) {
            System.out.print("\nEnter 1 for Number Conversion from base to base (supports all bases)");
            System.out.print("\nEnter 9 for Exit\n");

            int userOption = scanner.nextInt();
            scanner.nextLine(); // Consume leftover newline

            switch (userOption) {
                case 1 -> {
                    System.out.print("\nEnter the Value for Conversion: ");
                    String inputValue = scanner.nextLine();

                    System.out.print("\nEnter the Source Base: ");
                    int sourceBase = scanner.nextInt();

                    System.out.print("\nEnter the Target Base: ");
                    int targetBase = scanner.nextInt();

                    scanner.nextLine(); // Consume newline

                    String result = ConverterController.convertNumber(inputValue, sourceBase, targetBase);
                    if (result.contains("Error")) {
                        System.out.printf("\n%s", result);
                    } else {
                        System.out.printf("\nThe Converted Value for the given Target base - %s", result);
                    }
                }
                case 9 -> {
                    System.out.println("Exiting from the system");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid Option Selected");
            }
        }
    }

    public static void showMainMenu() {
        System.out.print("\nWelcome to Number Converter System!!!");
        while (true) {
            System.out.print("\nEnter 1 for Login");
            System.out.print("\nEnter 2 for Register");
            System.out.println("\nEnter 3 for Exit");

            int userOption = Integer.parseInt(scanner.nextLine());
            switch (userOption) {
                case 1 -> showLoginMenu();
                case 2 -> showRegisterMenu();
                case 3 -> {
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid Option Selected");
            }
        }
    }

    public static void showRegisterMenu() {
        System.out.print("\nEnter the Username: ");
        String username = scanner.nextLine();

        System.out.print("\nEnter the Password: ");
        String password = scanner.nextLine();

        int userId = AuthController.createUser(username, password);
        if (userId == -1) {
            System.out.println("Creation of user failed due to invalid inputs!");
            return;
        }

        showFeatureMenu(userId);
    }

    public static void showLoginMenu() {
        System.out.print("\nEnter the Username: ");
        String username = scanner.nextLine();

        System.out.print("\nEnter the Password: ");
        String password = scanner.nextLine();

        int userId = AuthController.verifyUser(username, password);
        if (userId == -1) {
            System.out.println("Login failed due to invalid credentials!");
            return;
        }

        showFeatureMenu(userId);
    }

    public static void showFeatureMenu(int userId) {

    }
}
