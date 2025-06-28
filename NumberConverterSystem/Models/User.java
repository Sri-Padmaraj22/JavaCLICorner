package Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import Models.Conversion;

public class User implements Serializable {
    public static Long serialVersionUID = 1L;
    public String userName, passCode;
    public int id;
    public ArrayList<Conversion> currentSession;
    public HashMap<String, ArrayList<Conversion>> history;

    public User(int id, String userName, String passCode) {
        this.id = id;
        this.userName = userName;
        this.passCode = passCode;
    }
}
