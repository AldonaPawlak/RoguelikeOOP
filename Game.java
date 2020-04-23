import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

class Game extends KeyAdapter {

    private Player player;
    private Mentor mentor;
    private final int width = 30;
    private final int height = 30;
    private List<Obstacle> obstacles;
    private String[][] board = new String[width][height];

    public Game() {
        this.player = new Player("player", " @", 5, 5);
        this.mentor = new Mentor("mentor", " &", 7, 7);
        player.setStatistics(3, 0, 0, 100);
        mentor.setStatistics(100, 100, 100, 100);
        this.obstacles = new ArrayList<>();
        createObstacles();
    }

    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    @Override
    public void keyPressed(KeyEvent event) {
        clearScreen();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" 
                         + "|w,s,a,d - moving |i - inventory | o - exit |\n"
                         + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        char ch = event.getKeyChar();

        switch (ch) {
            case 'w':
                player.move(new Coordinates(-1, 0));
                break;
            case 's':
                player.move(new Coordinates(1, 0));
                break;
            case 'a':
                player.move(new Coordinates(0, -1));
                break;
            case 'd':
                player.move(new Coordinates(0, 1));
                break;
            case 'i':
                player.printInventory();
                break;
            case 'o':
                System.exit(0);
                break;
        }
        printBoard();
    }

    public boolean isPlayerInRange(Obstacle obstacle, Coordinates coordinates) {
        int width = obstacle.getWidth();
        int height = obstacle.getHeight();
        Coordinates pivot = obstacle.getPivot();
        int x = this.player.getCoordinates().getX() + coordinates.getX();
        int y = this.player.getCoordinates().getY() + coordinates.getY();

        return x >= pivot.getX() && x < pivot.getX() + height && y >= pivot.getY() && y < pivot.getY() + width;
    }

    public boolean canPlayerMove(Coordinates coordinates) {
        for (Obstacle obstacle : obstacles) {
            if (isPlayerInRange(obstacle, coordinates)) {
                // obstacle.use(player);
                return false;
            }
        }
        return true;
    }

    public void createObstacles() {
        Obstacle wall1 = new Obstacle("wall1", " #", 0, 0, this.width, 1);
        Obstacle wall2 = new Obstacle("wall2", "#", 0, 0, 1, this.height);

        this.obstacles.add(wall1);
        this.obstacles.add(wall2);
        setObstacles();
    }

    public void setObstacles() {
        for (Obstacle obstacle : obstacles) {
            int width = obstacle.getWidth();
            int height = obstacle.getHeight();
            Coordinates pivot = obstacle.getPivot();

            for (int x = pivot.getX(); x < pivot.getX() + height; x++) {
                for (int y = pivot.getY(); y < pivot.getY() + width; y++) {
                    this.board[x][y] = obstacle.getSymbol();
                }
            }
        }
    }

    public void printBoard() {
        StringBuilder boardBuilder = new StringBuilder();

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (x == player.getCoordinates().getX() && y == player.getCoordinates().getY()) {
                    boardBuilder.append(player.getSymbol());
                } else if (x == mentor.getCoordinates().getX() && y == mentor.getCoordinates().getY()) {
                    boardBuilder.append(mentor.getSymbol());
                } else if (player.getCoordinates().getX() == mentor.getCoordinates().getX()
                        && player.getCoordinates().getY() == mentor.getCoordinates().getY()) {
                    //mentorInteraction();
                } else if (board[x][y] != null) {
                    boardBuilder.append(board[x][y]);
                } else {
                    boardBuilder.append(" .");
                }
            }
            boardBuilder.append("\n");
        }
        boardBuilder.append("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" 
                        + "|Health: " + player.getStatistics().getHealth() + "     | " 
                        + "Strength: " + player.getStatistics().getStrength() + "   | " 
                        + "Inteligence: " + player.getStatistics().getInteligence() + "|\n" 
                        + "|Happiness: " + player.getStatistics().getHappiness() + "| " 
                        + "Knowledge: " + player.getStatistics().getKnowledge()
                        + "|               |\n" + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println(boardBuilder.toString());
    }

    public void mentorInteraction(){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" 
                         + "|k - ask about knowledge amount |l - make consultation | m - try yourself with quality game |\n"
                         + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
    }
}