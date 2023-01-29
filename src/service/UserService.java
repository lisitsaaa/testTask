package service;

import entity.User;
import storage.FileUserStorage;
import storage.UserStorage;

public class UserService {
    private final UserStorage userStorage = new FileUserStorage();

    public void createUser(User user){
        userStorage.createUser(user);
    }

    public void getAllInfo(){
        userStorage.printAllInfo();
    }

    public void getInfoById(int userId){
        userStorage.printInfoById(userId);
    }

    public void removeAllInfo(){
        userStorage.removeAllInfo();
    }

    public void removeInfoById(int userId){
        userStorage.removeInfoById(userId);
    }
}
