package console;

import entity.Phone;
import entity.User;
import validator.UserValidator;

import java.util.*;

import static console.util.ConsoleMessage.*;
import static console.util.ConsoleReader.*;
import static console.util.ConsoleWriter.write;

public class ConsoleValidator {
    public static List<Phone> addPhoneNumbers() {
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
                case 2 -> {
                    return phones;
                }
            }
        }
        return phones;
    }

    public static Set<User.Role> addRoles() {
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
                case 2 -> {
                    return roles;
                }
            }
        }
        return roles;
    }

        public static String validateInfo(String message, int code) {
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

    private static String readInfo(String message) {
        write(message);
        return readString();
    }
}
