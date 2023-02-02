package validator;

import entity.User;

import java.util.*;

import static console.util.ConsoleMessage.*;
import static console.util.ConsoleWriter.*;

public final class UserValidator {
    public static final String NAME_FAMILY_NAME = "^[A-Za-z]{2,16}$";
    public static final String PHONE_NUMBER = "^(\\+375|80)(29|25|44|33)(\\d{3})(\\d{2})(\\d{2})$";
    public static final String EMAIL = "^[\\w-]{2,16}@([\\w-]{2,5}\\.)+[\\w-]{2,4}$";
    public static final String SUPER_ADMIN = "SUPER_ADMIN";

    public static boolean isValidNameFamilyName(String name) {
        if (!name.matches(NAME_FAMILY_NAME)) {
            writeError(name + INVALID_MESSAGE);
            return false;
        }
        return true;
    }

    public static boolean isValidPhoneNumber(String numbers) {
        String[] arrNumber = numbers.split(" ");
        if (arrNumber.length > 3) {
            writeError(PHONE_SIZE_MESSAGE);
        }

        for (String number : arrNumber) {
            if (!number.matches(PHONE_NUMBER)) {
                writeError(number + INVALID_MESSAGE);
                return false;
            }
        }
        return true;
    }

    public static boolean isValidEmail(String email) {
        if (!email.matches(EMAIL)) {
            writeError(email + INVALID_MESSAGE);
            return false;
        }
        return true;
    }

    public static boolean isValidRoles(Set<User.Role> roles) {
        if (roles.size() > 2) {
            writeError(ROLE_SIZE_MESSAGE);
            return false;
        }

        if (roles.size() == 2) {
            if (roles.stream()
                    .anyMatch(role -> role.getLevel() == User.Role.SUPER_ADMIN.getLevel())) {
                writeError(SUPER_ADMIN_MESSAGE);
                return false;
            }
        }
        if(roles.size() == 2){
            List<Integer> level = new ArrayList<>();

            for(User.Role role : roles){
                level.add(role.getLevel());
            }

            if(level.get(0).equals(level.get(1))){
                writeError(LEVEL_MESSAGE);
            }
            return false;
        }
        return true;
    }

}
