package Controllers;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;

import Models.User;

public class AuthController {
    public static ArrayList<User> AoU;

    static {
        AuthController.loadUserList();
    }

    public static boolean saveUserList() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
                "E:\\CODE GALLATA\\OVERALL NOTES\\LONG CODING & DESIGN PATTERNS\\SAMPLE CODE\\NumberConverterSystem\\Files\\User.txt"));) {
            oos.writeObject(AoU);
            return true;
        } catch (Exception e) {
            System.out.println("There was an problem while saving the user file" + e.getMessage());
            return false;
        }
    }

    public static void loadUserList() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
                "E:\\CODE GALLATA\\OVERALL NOTES\\LONG CODING & DESIGN PATTERNS\\SAMPLE CODE\\NumberConverterSystem\\Files\\User.txt"))) {
            AoU = (ArrayList<User>) ois.readObject();
        } catch (Exception e) {
            System.out.println("There was an problem while loading the user file");
        }
    }

    public static int createUser(String userName, String passCode) {
        if (userName != null && passCode != null && !userName.trim().equals("") && !passCode.trim().equals("")) {
            int id = new Random().nextInt();
            AoU.add(new User(id, userName, passCode));
            if (!AuthController.saveUserList()) {
                AoU.removeIf((x) => {x.userName == userName});
            }
            return id;
        }
        return -1;
    }

    public static int verifyUser(String userName, String passCode) {
        for (User u : AoU) {
            if (u.userName.equals(userName) && u.passCode.equals(passCode)) {
                return u.id;
            }
        }
        return -1;
    }
}
