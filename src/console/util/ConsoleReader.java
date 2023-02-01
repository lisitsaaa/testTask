package console.util;

import java.util.Scanner;

public final class ConsoleReader {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static String readString() {
        return SCANNER.next();
    }

    public static String readAllString(){
        return SCANNER.nextLine();
    }

    public static int readInt() {
        return SCANNER.nextInt();
    }
}
