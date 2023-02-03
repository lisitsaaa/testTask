package storage;

import entity.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUserStorage implements UserStorage {
    private static final String FILE_NAME = "userStorage.txt";
    private int ids = 1;

    @Override
    public void saveUser(User user) {
        user.setId(ids++);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(user + System.lineSeparator());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<String> findAllInfo() {
        List<String> allInfo = new ArrayList<>();
        String store;
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            while ((store = reader.readLine()) != null) {
                allInfo.add(store);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return allInfo;
    }


    @Override
    public void removeAllInfo() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, false))) {
            writer.write("");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeInfoById(int userId) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            List<String> allInfo = new ArrayList<>();
            String store;

            while ((store = reader.readLine()) != null) {
                allInfo.add(store);
            }
            allInfo.remove(userId);

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, false))) {
                for (String str : allInfo) {
                    writer.write(str + System.lineSeparator());
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void editUser(User user) {
        removeInfoById(user.getId());
    }
}
