package console;

import entity.Phone;
import entity.User;
import service.UserService;
import validator.UserValidator;

import java.util.*;

import static console.util.ConsoleReader.*;
import static console.util.ConsoleWriter.*;
import static console.util.ConsoleMessage.*;

public class ConsoleApplication implements Application {
    private final UserService userService = new UserService();


    @Override
    public void run() {
        while (true) {
            write(MENU);
            switch (readInt()) {
                case 1 -> createUser();
//            case 2 -> userService.editInfoById();
                case 3 -> userService.getAllInfo();
                case 4 -> {
                    write(ID_MESSAGE);
                    userService.getInfoById(readInt());

                }
                case 5 -> userService.removeAllInfo();
                case 6 -> {
                    write(ID_MESSAGE);
                    userService.removeInfoById(readInt());
                }
                case 7 -> {
                    write(BYE_MESSAGE);
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
        String name = validateInfo(NAME_MESSAGE, 1);
        String familyName = validateInfo(FAMILY_NAME_MESSAGE, 1);
        String email = validateInfo(EMAIL_MESSAGE + "\n" + EXAMPLE_EMAIL, 2);
        List<Phone> phones = addPhoneNumbers();
        Set<User.Role> roles = addRoles();
        userService.createUser(name, familyName, email, phones, roles);
    }

    private String validateInfo(String message, int code) {
        boolean validator = false;
        String info;
        do {
            info = readInfo(message);
            switch (code) {
                case 1 -> validator = UserValidator.isValidNameFamilyName(info);
                case 2 -> validator = UserValidator.isValidEmail(info);
            }
        } while (!validator);
        return info;
    }

    private List<Phone> addPhoneNumbers() {
        List<Phone> phones = new ArrayList<>();

        write(PHONES_MESSAGE + "\n" + EXAMPLE_PHONES);
        readAllString();
        String numbers = readAllString();

        if (UserValidator.isValidPhoneNumber(numbers)) {
            String[] arrNumber = numbers.split(" ");
            for (String number : arrNumber) {
                Phone phone = new Phone(number);
                phones.add(phone);
            }
        } else {
            write(QUESTION_MESSAGE);
            switch (readInt()) {
                case 1 -> phones = addPhoneNumbers();
                case 2 -> run();
            }
        }
        return phones;
    }

    private Set<User.Role> addRoles() {
        Set<User.Role> roles = new TreeSet<>();

        write(ROLES_MESSAGE);
        readAllString();
        String roleStr = readAllString().toUpperCase();

        if (UserValidator.isValidRoles(roleStr)) {
            String[] arrRole = roleStr.split(" ");

            for (String role : arrRole) {
                switch (role.toUpperCase()) {
                    case "USER" -> roles.add(User.Role.USER);
                    case "CUSTOMER" -> roles.add(User.Role.CUSTOMER);
                    case "ADMIN" -> roles.add(User.Role.ADMIN);
                    case "PROVIDER" -> roles.add(User.Role.PROVIDER);
                    case "SUPER_ADMIN" -> roles.add(User.Role.SUPER_ADMIN);
                }
            }
        } else {
            write(QUESTION_MESSAGE);
            switch (readInt()) {
                case 1 -> roles = addRoles();
                case 2 -> run();
            }
        }
        return roles;
    }
}
