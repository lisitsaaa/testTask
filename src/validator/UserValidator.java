package validator;

import entity.User;

import java.util.*;

import static console.util.ConsoleWriter.*;

public final class UserValidator {
    public static final String NAME_FAMILY_NAME = "^[A-Za-z]{2,16}$";
    public static final String PHONE_NUMBER = "^(\\+375|80)(29|25|44|33)(\\d{3})(\\d{2})(\\d{2})$";
    public static final String EMAIL = "^[\\w-]{2,16}@([\\w-]{2,5}\\.)+[\\w-]{2,4}$";

    public static boolean isValidNameFamilyName(String name) {
        if (!name.matches(NAME_FAMILY_NAME)) {
            writeError(name + " is invalid");
            return false;
        }
        return true;
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        if (!phoneNumber.matches(PHONE_NUMBER)) {
            writeError(phoneNumber + " is invalid");
            return false;
        }
        return true;
    }

    public static boolean isValidPhoneSize(int size) {
        if (size < 0 || size > 4) {
            writeError("invalid size -> (1-3)");
            return false;
        }
        return true;
    }

    public static boolean isValidEmail(String email) {
        if (!email.matches(EMAIL)) {
            writeError(email + " is invalid");
            return false;
        }
        return true;
    }

    public static boolean isValidRoles(Set<User.Role> roles) {
        if (roles.size() > 3) {
            writeError("invalid size -> (1-2)");
            return false;
        }

        if (roles.size() == 2) {
            if (roles.stream()
                    .anyMatch(role -> role.getLevel() == User.Role.SUPER_ADMIN.getLevel())) {
                writeError("only SUPER_ADMIN");
                return false;
            }
        }
//        if (roles.size() == 2) {
//            List<User.Role> user = roles.stream()
//                    .filter(role -> role.getLevel() == User.Role.USER.getLevel())
//                    .toList();
//
//            List<User.Role> customer = roles.stream()
//                    .filter(role -> role.getLevel() == User.Role.CUSTOMER.getLevel())
//                    .toList();
//        }


//        if (roles.size() == 2) {
//            if (roles.stream()
//                    .anyMatch(role -> role.getLevel() == User.Role.USER.getLevel() &&
//                            role.getLevel() == User.Role.CUSTOMER.getLevel())) {
//
//                writeError("you must use different levels");
//                return false;
//            }
//        }

//        if (roles.size() == 2) {
//            if (roles.stream()
//                    .anyMatch(role -> role.getLevel() == User.Role.ADMIN.getLevel() &&
//                            role.getLevel() == User.Role.PROVIDER.getLevel())) {
//                writeError("you must use different levels");
//                return false;
//            }
//        }
        return true;
    }



}
