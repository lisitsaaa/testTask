package console.util;

import java.util.Scanner;

public final class ConsoleReader {

    public static String readString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public static String readAllString(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static int readInt() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
