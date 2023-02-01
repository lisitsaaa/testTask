package storage;

import entity.User;

import java.io.File;
import java.util.List;

import static console.util.ConsoleMessage.FILE_MESSAGE;
import static console.util.ConsoleWriter.write;

public interface UserStorage {
    void createUser(User user);
    void editUser(User user);
    void printAllInfo();

    List<String> printInfoById(int userId);

    void removeAllInfo();

    void removeInfoById(int userId);

    static boolean isCheckingFile(String fileName) {
        File file = new File(fileName);
        if(!file.exists()){
            write(FILE_MESSAGE);
            return false;
        }
        return true;
    }

}
