package console;

import entity.Phone;
import entity.User;
import service.UserService;

import java.util.List;
import java.util.Set;

import static console.ConsoleValidator.*;
import static console.util.ConsoleReader.*;
import static console.util.ConsoleWriter.*;
import static console.util.ConsoleMessage.*;

public class ConsoleApplication {
    private final UserService userService = new UserService();

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

    public void createUser() {
        String name = validateInfo(NAME_MESSAGE, 1);
        String familyName = validateInfo(FAMILY_NAME_MESSAGE, 1);
        String email = validateInfo(EMAIL_MESSAGE + "\n" + EXAMPLE_EMAIL, 2);
        List<Phone> phones = addPhoneNumbers();
        Set<User.Role> roles = addRoles();

        userService.createUser(name, familyName, email, phones, roles);
    }
}
