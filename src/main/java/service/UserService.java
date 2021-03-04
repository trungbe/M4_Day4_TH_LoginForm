package service;

import model.Login;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User("trung", "123456", "Trung", "trung@gmail.com", 23));
        users.add(new User("dat", "123456", "dat", "dat@gmail.com", 26));
        users.add(new User("thinh", "123456", "thinh", "thinh@gmail.com", 28));
        users.add(new User("hung", "123456", "hung", "hung@gmail.com", 28));


    }


    public static User checkLogin(Login login) {
        for (User u : users) {
            if (u.getAccount().equals(login.getAccount())
                    && u.getPassword().equals(login.getPassword())) {
                return u;
            }
        }
        return null;
    }
}

