package storage;

import entity.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static console.util.ConsoleWriter.write;
public class FileUserStorage implements UserStorage {
    private static final String FILE_NAME = "userStorage.txt";
    private long ids = 1;

    @Override
    public void createUser(User user) {
        user.setId(ids++);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(user + System.lineSeparator());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        users.add(user);
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
    public void printInfoById(int userId) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            List<String> allInfo = new ArrayList<>();
            String store;

            while((store = reader.readLine()) != null){
                allInfo.add(store);
            }
            write(allInfo.get(userId));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
                writer.write(allInfo + System.lineSeparator());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
