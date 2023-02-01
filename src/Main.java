import console.ConsoleApplication;
import storage.UserStorage;

import static console.util.ConsoleMessage.FILE_MESSAGE;
import static console.util.ConsoleReader.readString;
import static console.util.ConsoleWriter.write;

public class Main {
    public static void main(String[] args) {
        write(FILE_MESSAGE);
            if(UserStorage.isCheckingFile(readString())){
                ConsoleApplication app = new ConsoleApplication();
                app.run();
            }
    }
}
