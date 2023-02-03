package console;

import entity.User;
import validator.UserValidator;

import java.util.*;

import static console.util.ConsoleMessage.*;
import static console.util.ConsoleReader.*;
import static console.util.ConsoleWriter.write;

public class ConsoleUserController {
    private static boolean validator = false;
    private void askAboutAContinue(){
        write(QUESTION_MESSAGE);
        if(readInt() == 1){

        }
    }

    public static Set<User.Role> addRoles() {
        Set<User.Role> roles = new TreeSet<>();
        do {
            roles.stream().toList().forEach(roles::remove);
            write(ROLES_MESSAGE);
//            readAllString();
            String roleStr = readAllString().toUpperCase();
            String[] arrRole = roleStr.split(" ");

            for (String role : arrRole) {
                switch (role.toUpperCase()) {
                    case "USER" -> roles.add(User.Role.USER);
                    case "CUSTOMER" -> roles.add(User.Role.CUSTOMER);
                    case "ADMIN" -> roles.add(User.Role.ADMIN);
                    case "PROVIDER" -> roles.add(User.Role.PROVIDER);
                    case "SUPER_ADMIN" -> roles.add(User.Role.SUPER_ADMIN);
                }
                validator = UserValidator.isValidRoles(roles);
            }
        } while (!validator);
        return roles;
    }

    public static String validatePhone() {
        String info;
        do {
            write(PHONES_MESSAGE + "\n" + EXAMPLE_PHONES);
            readAllString();
            info = readAllString();
            validator = UserValidator.isValidPhoneNumber(info);
        } while (!validator);
        return info;
    }


    public static String validateInfo(String message, int code) {
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
