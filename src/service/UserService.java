package service;

import entity.Phone;
import entity.User;
import storage.FileUserStorage;
import storage.UserStorage;

import java.util.List;
import java.util.Set;

import static console.util.ConsoleWriter.write;

public class UserService {
    private final UserStorage userStorage = new FileUserStorage();

    public void createUser(String name, String familyName,
                           String email, List<Phone> phones,
                           Set<User.Role> roles) {
        Runnable runnable = () -> {
            User user = new User(name, familyName, email, phones, roles);
            userStorage.createUser(user);
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    public void getAllInfo() {
        userStorage.printAllInfo();
    }

    public void getInfoById(int userId) {
        List<String> allInfo = userStorage.printInfoById(userId);
        write(allInfo.get(userId));
    }

    public void removeAllInfo() {
        Runnable runnable = userStorage::removeAllInfo;
        Thread thread = new Thread(runnable);
        thread.start();
    }

    public void removeInfoById(int userId) {
        Runnable runnable = () ->
                userStorage.removeInfoById(userId);
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
