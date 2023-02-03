package storage;

import entity.User;

import java.io.File;
import java.util.List;

import static console.util.ConsoleMessage.FILE_NOT_FOUND_MESSAGE;
import static console.util.ConsoleWriter.write;

public interface UserStorage {
    void saveUser(User user);
    void editUser(User user);
    List<String> findAllInfo();
    void removeAllInfo();
    void removeInfoById(int userId);

    static boolean isCheckingFile(String fileName) {
        File file = new File(fileName);
        if(!file.exists()){
            write(FILE_NOT_FOUND_MESSAGE);
            return false;
        }
        return true;
    }

}
