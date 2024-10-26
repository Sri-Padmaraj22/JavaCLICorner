package Controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import Models.User;

public class UserController {
    private static List<User> AoU;
    private static String USERS_FILE = "E:/JAVA PT/Basics_Of_OOPs/JavaCLICorner/BroadBandApp/File/Users.txt";

    static {
        System.out.println("static block");
        loadUserFile();
    }

    @SuppressWarnings("unchecked")
    public static void loadUserFile() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(USERS_FILE));
            AoU = (List<User>) ois.readObject();
            System.out.println(AoU);
            ois.close();
        } catch (Exception e) {
            System.out.println("Some exception raised during the saving of the user file");
        }
    }

    public static void saveUserFile() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USERS_FILE));
            oos.writeObject(AoU);
            oos.close();
        } catch (Exception e) {
            System.out.println("Some exception raised during the saving of the user file");
        }
    }

    public static int LoginUser(String uname, String upass) {
        if (AoU == null) {
            System.out.println("intha code");
            AoU = new ArrayList<User>();
            return -1;
        }
        for (User u : AoU) {
            if (u.nameGetter().equals(uname) && u.passwordGetter().equals(upass)) {
                return u.idGetter();
            }
        }
        return -1;
    }

    public static void displayUser(int id) {
        for (User i : AoU) {
            if (i.idGetter() == id) {
                i.toString();
            }
        }
    }

    public static void UpdateUser(int uId, String name, String password, String address, String mobile) {
        for (User i : AoU) {
            if (uId == i.idGetter()) {
                i.updateSetter(name, password, address, mobile);
                System.out.println("Updated the account information successfully");
            }
        }
        System.out.println("Update not done");
    }

    public static int AddUser(String name, String pass, String address, String mobile) {
        AoU.add(new User(AoU.size() + 1, name, pass, address, mobile));
        UserController.saveUserFile();
        System.out.print("New User added successfully");
        return AoU.size();
    }

    public static User RetreiveUser(int uId) {
        for (User i : AoU) {
            if (i.idGetter() == uId) {
                return i;
            }
        }
        return null;
    }
}
