import java.util.Scanner;

import Controllers.AuthController;
import Controllers.ConverterController;
import Models.User;

public class Main {
    public static void main(String[] args) {

        Main.MainMenu();
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Number Converter System!!!");

        while (true) {
            System.out.print("\nEnter 1 for Number Conversion from base to base ( supports all bases )");
            System.out.print("\nEnter 9 for Exit\n");
            int UserOption = sc.nextInt();
            sc.nextLine();
            switch (UserOption) {
                case 1 -> {
                    System.out.print("\nEnter the Value for Conversion : ");
                    String UserValue = sc.nextLine();
                    System.out.print("\nEnter the Source Base : ");
                    int UserSourceBase = sc.nextInt();
                    System.out.print("\nEnter the Target Base : ");
                    int UserTargetBase = sc.nextInt();
                    String result = ConverterController.convert(UserValue, UserSourceBase, UserTargetBase);
                    if (result.contains("Error")) {
                        System.out.printf("\n%s", result);
                    } else {
                        System.out.printf("\nThe Converted Value for the given Target base - %s", result);
                    }
                }
                case 9 -> {
                    System.out.println("Exiting from the system");
                    sc.close();
                    return;
                }
            }
        }
    }

    public static void MainMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nWelcome to Number Converter System!!!");
        while (true) {
            System.out.print("\nEnter 1 for Login");
            System.out.print("\nEnter 2 for Register");
            System.out.println("\nEnter 3 for Exit");

            int userOption = Integer.parseInt(sc.nextLine());
            switch (userOption) {
                case 1 -> Main.LoginMenu();
                case 2 -> Main.RegisterMenu();
                case 3 -> {
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                }
                default -> {
                    System.out.println("Invalid Option is being selected");
                }
            }
        }
    }

    public static void RegisterMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the Username : ");
        String userName = sc.nextLine();
        System.out.print("\nEnter the Passcode : ");
        String passCode = sc.nextLine();
        int uid = AuthController.createUser(userName, passCode);
        if (uid == -1) {
            System.out.println("Creation of user has been failed due to invalid inputs!");
            return;
        }
        Main.FeatureMenu(uid);
    }

    public static void LoginMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the Username : ");
        String userName = sc.nextLine();
        System.out.print("\nEnter the Passcode : ");
        String passCode = sc.nextLine();
        int uid = AuthController.verifyUser(userName, passCode);
        if (uid == -1) {
            System.out.println("Creation of user has been failed due to invalid inputs!");
            return;
        }
        Main.FeatureMenu(uid);
    }

    public static void FeatureMenu(int uid) {

    }
}
