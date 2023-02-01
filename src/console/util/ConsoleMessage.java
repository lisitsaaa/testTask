package console.util;

public final class ConsoleMessage {
    public static final String FILE_MESSAGE = "enter file name -> userStorage.txt";
    public static final String FILE_NOT_FOUND_MESSAGE = "file not found:(";
    public static final String MENU = """
            1 - create          2 - edit
            3 - get all         4 - get by id
            5 - remove all      6 - remove by id
            7 - exit""";
    public static final String BYE_MESSAGE = "see you!";
    public static final String QUESTION_MESSAGE = """
            1 - try again
            2 - go back to the menu""";
    public static final String ID_MESSAGE = "enter id";
    public static final String NAME_MESSAGE = "enter name";
    public static final String FAMILY_NAME_MESSAGE = "enter familyName";
    public static final String EMAIL_MESSAGE = "enter email";
    public static final String PHONES_MESSAGE = "enter 1-3 phone numbers";
    public static final String ROLES_MESSAGE = """
            LEVEL 1:
                    USER
                    CUSTOMER
            LEVEL 2:
                    ADMIN
                    PROVIDER
            LEVEL 3:
                    SUPER_ADMIN""";
    public static final String EXAMPLE_PHONES = "example: +375447898765 80332345612 +375298765434";
    public static final String EXAMPLE_EMAIL = "example: kateLasitsa@mail.ru";

    public static final String INVALID_MESSAGE = "is invalid";
    public static final String PHONE_SIZE_MESSAGE = "invalid size -> (1-3)";
    public static final String ROLE_SIZE_MESSAGE = "invalid size -> (1-2)";
    public static final String SUPER_ADMIN_MESSAGE = "only SUPER_ADMIN";
    public static final String LEVEL_MESSAGE = "you must use different levels";
}
