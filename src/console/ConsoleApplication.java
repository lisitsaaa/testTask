package console;

import entity.Phone;
import entity.User;
import service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static console.ConsoleUserController.*;
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
                case 3 -> {
                    List<String> allInfo = userService.getAllInfo();
                    for (String info : allInfo) {
                        write(info);
                    }
                }
                case 4 -> {
                    write(ID_MESSAGE);
                    int id = readInt();
                    List<String> allInfo = userService.getAllInfo();
                    write(allInfo.get(id));
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
        List<Phone> phones = addPhone();
        Set<User.Role> roles = addRoles();

        userService.createUser(name, familyName, email, phones, roles);
    }

    public List<Phone> addPhone() {
        List<Phone> phones = new ArrayList<>();

        String numbers = validatePhone();
        String[] arrNumber = numbers.split(" ");

        for (String number : arrNumber) {
            Phone phone = new Phone(number);
            phones.add(phone);
        }
        return phones;
    }
}
