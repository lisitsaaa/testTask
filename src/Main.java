import console.ConsoleApplication;
import storage.UserStorage;

import static console.util.ConsoleReader.*;
import static console.util.ConsoleWriter.*;

public class Main {
    public static void main(String[] args) {
        write("enter file name");
            if(UserStorage.isCheckingFile(readString())){
                ConsoleApplication app = new ConsoleApplication();
                app.run();
            }
    }
}
