package console;

import entity.Phone;
import entity.User;
import service.UserService;
import validator.UserValidator;

import java.util.*;

import static console.util.ConsoleReader.*;
import static console.util.ConsoleWriter.*;

public class ConsoleApplication implements Application {
    private final UserService userService = new UserService();
    private static final String CHOICE_ID = "enter id";

    @Override
    public void run() {
        while (true) {
            write("""
                    1 - create          2 - edit
                    3 - get all         4 - get by id
                    5 - remove all      6 - remove by id
                    7 - exit""");
            switch (readInt()) {
                case 1 -> createUser();
//            case 2 -> userService.editInfoById();
                case 3 -> userService.getAllInfo();
                case 4 -> {
                    write(CHOICE_ID);
                    userService.getInfoById(readInt());

                }
                case 5 -> userService.removeAllInfo();
                case 6 -> {
                    write(CHOICE_ID);
                    userService.removeInfoById(readInt());
                }
                case 7 -> {
                    write("see you!");
                    return;
                }
            }
        }
    }

    private String readInfo(String message) {
        write(message);
        return readString();
    }

    private void createUser() {
        String name = validateInfo("enter name", 1);
        String familyName = validateInfo("enter familyName", 1);
        String email = validateInfo("enter email", 2);
        List<Phone> phones = addPhoneNumbers();
        Set<User.Role> roles = addRoles();

        User user2 = new User(name, familyName, email, phones, roles);
        userService.createUser(user2);
        write(user2.toString());
    }

    private String validateInfo(String message, int code) {
        boolean validator = false;
        String info;
        do {
            info = readInfo(message);
            switch (code) {
                case 1 -> validator = UserValidator.isValidNameFamilyName(info);
                case 2 -> validator = UserValidator.isValidEmail(info);
                case 3 -> validator = UserValidator.isValidPhoneNumber(info);
            }
        } while (!validator);
        return info;
    }

    private List<Phone> addPhoneNumbers() {
        List<Phone> phoneNumbers = new ArrayList<>();
        boolean validator;
        do {
            write("how much phones do you wanna add?");
            int answer = readInt();
            validator = UserValidator.isValidPhoneSize(answer);

            for (int i = 0; i < answer; i++) {
                String number = validateInfo("enter number", 3);
                Phone phone = new Phone(number);
                phoneNumbers.add(phone);
            }
        } while (!validator);

        return phoneNumbers;
    }

    private Set<User.Role> addRoles() {
        Set<User.Role> roles = new TreeSet<>();
        boolean validator = false;
        do {
            write("how much roles do you wanna add?");
            int answer = readInt();

            for (int i = 0; i < answer; i++) {
                write("""
                        LEVEL 1:
                                USER
                                CUSTOMER
                        LEVEL 2:
                                ADMIN
                                PROVIDER
                        LEVEL 3:
                                SUPER_ADMIN""");
                switch (readString().toUpperCase()) {
                    case "USER" -> roles.add(User.Role.USER);
                    case "CUSTOMER" -> roles.add(User.Role.CUSTOMER);
                    case "ADMIN" -> roles.add(User.Role.ADMIN);
                    case "PROVIDER" -> roles.add(User.Role.PROVIDER);
                    case "SUPER_ADMIN" -> roles.add(User.Role.SUPER_ADMIN);
                }
                validator = UserValidator.isValidRoles(roles);
                if(!validator){
                    roles.stream().toList().forEach(roles::remove);
                }
            }
        } while (!validator);
        return roles;
    }
}
