import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class Ui {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private Game game = new Game();
    public String takeUserInput(String messageForUser) throws IOException {
        System.out.print(messageForUser);
        return reader.readLine();
    }

    private void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }


    public void gameMenu() throws IOException {
        boolean gameContinue = true;
        while (gameContinue){
            printMenu();
            String userOption = takeUserInput("Enter option: ");
            clearScreen();
            switch(userOption){
                case "1":
                    game();
                    gameContinue = false;
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

    private void game() throws IOException {
        JTextField textField = new JTextField();
        textField.addKeyListener(game);
        JFrame jframe = new JFrame();
        jframe.add(textField);
        jframe.setSize(100, 100);
        jframe.setVisible(true);
        game.printBoard();

    }

    private void printMenu(){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
                         + "|                 ROGUELIKE ALDOMAT               |\n"
                         + "|-------------------------------------------------|\n"
                         + "|1 - Start game          |3 - Show scores         |\n"
                         + "|2 - Show instruction    |0 - EXIT                |\n"
                         + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
    }


    private void printInstruction(){
        String instruction = "                  ROGUELIKE ALDOMAT INSTRUCTION               \n\n"
                           + "HISTORY\n"
                           + "Welcome to roguelike game 'AldoMat'! You've just attended to programming course in school named CodeCool.\n"
                           + "Your aim is to learn programming and pass quality gates to achieve next levels and finally get a job. Don't let your character starve and collect\n"
                           + "cofee and other food (to gain strength for another portion of knowledge). You can make a consultation with mentors if you feel sad and think taht your knowledge\n"
                           + "is not high enough. \n\n"
                           + "HOW TO PLAY\n"
                           + "Moving with keys: W, S, A, D. You can't go outside the walls. At the beggining you're a monkey (114).\n"
                           + "-> First level is a Python module where you must collect all snake tips (589).\n"
                           + "-> Second is Java OOP module where you must collect all Java packages (1226).\n"
                           + "-> Next one is Web module where you are collecting webs (614).\n"
                           + "-> The fourth is Adwanced module where you are the best programmer in the world, so you must cope with time pressure\n"
                           + "   and collect all padlocks (1248) to open the Staff Room.\n"
                           + "-> Finally you evolve into programmer and when you got into this room, Codecool staff will give you job and you can\n"
                           + "   enjoy your new luxurious programmer life!\n\n"
                           + "Your charcter has health, sterngth, inteligence, happiness and knowledge. Health equals 3 and it can't be added. It's associated with 3 trials to pass levels\n"
                           + "so after you don't pass quality gate,you loose 1 life. Strength equals 0 and it decrease by 1 while you're collecting module items (e.g. Java packages)\n"
                           + "so you must go to kitchen first and get some snacks or cofee to increase strength. Be careful because when your energy is lower than 0 - you loose!\n"
                           + "Inteligence is 0 as well at the beggining and you gain it by collecting module items(1 module item gives +1 inteligence but -1 strength).\n"
                           + "Happiness equals 100 at the beggining and decrease by 5 while collecting module items. You can refill it by making consultation with mentors that returns\n"
                           + "full (100) happiness. You can have only 1 consultation per module so use it smartly.\n"
                           + "Knowledge is product of strength and inteligence and added happiness (knowledge = [strength*inteligence]+happiness) so you should be full of strength and happiness\n"
                           + "and gain enough inteligence while passing quality gates. You can check how big knowledge you should have to pass by interacting with mentor.\n"
                           + "Kitchen is opened all game so you can go there to refil energy with cofee and some snacks. Doors opens as you are passing next modules.\n";

        System.out.println(instruction);
    }
}