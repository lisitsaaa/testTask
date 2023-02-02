package storage;

import entity.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static console.util.ConsoleWriter.*;

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
    public void printAllInfo() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String store;

            while ((store = reader.readLine()) != null){
                write(store);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void removeAllInfo() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, false))) {
            writer.write("");
            write("all info has been removed");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<String> printInfoById(int userId) {
        List<String> allInfo = new ArrayList<>();
        String store;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            while((store = reader.readLine()) != null){
                allInfo.add(store);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return allInfo;
    }

    @Override
    public void removeInfoById(int userId) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            List<String> allInfo = new ArrayList<>();
            String store;

            while((store = reader.readLine()) != null){
                allInfo.add(store);
            }
            allInfo.remove(userId);

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, false))) {
                for(String str : allInfo){
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
