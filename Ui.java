import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ui {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public String takeUserInput(String messageForUser) throws IOException {
        System.out.print(messageForUser);
        return reader.readLine();
    }

    public void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void printInstruction(){
        System.out.println("Instruction");
    }

    public void gameMenu() throws IOException {
        boolean gameContinue = true;
        while (gameContinue){
            printMenu();
            String userOption = takeUserInput("Enter option: ");
            clearScreen();
            switch(userOption){
                case "1":
                    // Game
                    break;
                case "2":
                    printInstruction();
                    break;
                case "3":
                    // Scores
                    break;
                case "0":
                    gameContinue = false;
                    break;
                default:
                    System.out.println("Wrong option!");
                    gameMenu();
                    break;
            }
        }
        
    }

    private void printMenu(){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
                         + "|                 ROGUELIKE ALDOMAT               |\n"
                         + "|-------------------------------------------------|\n"
                         + "|1 - Start game          |3 - Show scores         |\n"
                         + "|2 - Show instruction    |0 - EXIT                |\n"
                         + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
    }
}