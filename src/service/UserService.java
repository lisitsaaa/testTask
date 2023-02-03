package service;

import entity.Phone;
import entity.User;
import storage.FileUserStorage;
import storage.UserStorage;

import java.util.List;
import java.util.Set;

public class UserService {
    private final UserStorage userStorage = new FileUserStorage();

    public void createUser(String name, String familyName,
                           String email, List<Phone> phones,
                           Set<User.Role> roles) {
        User user = new User(name, familyName, email, phones, roles);
        saveUser(user);
    }

    private void saveUser(User user) {
        Thread thread = new Thread(() -> {
            userStorage.saveUser(user);
        });
        thread.start();
    }

    public List<String> getAllInfo() {
        return userStorage.findAllInfo();
    }

    public void removeAllInfo() {
        Runnable runnable = userStorage::removeAllInfo;
        Thread thread = new Thread(runnable);
        thread.start();
    }

    public void removeInfoById(int userId) {
        Thread thread = new Thread(() -> {
            userStorage.removeInfoById(userId);
        });
        thread.start();
    }
}
