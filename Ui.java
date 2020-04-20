import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ui {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String takeUserInput(String messageForUser) throws IOException {
        System.out.print(messageForUser);
        return reader.readLine();
    }

    public static void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static String instruction(){
        return "instruction";
    }

    public static String gameMenu(){
        return "menu";
    }
}