package storage;

import entity.User;

public interface UserStorage {
    void createUser(User user);

    void printAllInfo();

    void printInfoById(int userId);

    void removeAllInfo();

    void removeInfoById(int userId);


}
