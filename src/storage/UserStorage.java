package storage;

import entity.User;

import java.util.List;

public interface UserStorage {
    void createUser(User user);
    void editUser(User user);
    void printAllInfo();

    List<String> printInfoById(int userId);

    void removeAllInfo();

    void removeInfoById(int userId);

}
