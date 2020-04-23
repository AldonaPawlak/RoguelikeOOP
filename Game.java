import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

class Game extends KeyAdapter {

    private Player player;
    private Mentor mentor;
    private final int width = 80;
    private final int height = 30;
    private List<Obstacle> obstacles;
    private String[][] board = new String[height][width];

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
                if (canPlayerMove(new Coordinates(-1, 0))) {
                player.move(new Coordinates(-1, 0));
                }
                break;
            case 's':
            if (canPlayerMove(new Coordinates(1, 0))) {
                player.move(new Coordinates(1, 0));
                }
                break;
            case 'a':
            if (canPlayerMove(new Coordinates(0, -1))) {
                player.move(new Coordinates(0, -1));
                }
                break;
            case 'd':
            if (canPlayerMove(new Coordinates(0, 1))) {
                player.move(new Coordinates(0, 1));
                }
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
        int x = this.player.getCoordinates().getRowIndex() + coordinates.getRowIndex();
        int y = this.player.getCoordinates().getColumnIndex() + coordinates.getColumnIndex();

        return x >= pivot.getRowIndex() && x < pivot.getRowIndex() + height && y >= pivot.getColumnIndex() && y < pivot.getColumnIndex() + width;
    }

    public boolean canPlayerMove(Coordinates coordinates) {
        for (Obstacle obstacle : obstacles) {
            if (isPlayerInRange(obstacle, coordinates)) {
                obstacle.use(player);
                return false;
            }
        }
        return true;
    }

    public void createObstacles() {
        Obstacle wall1 = new Obstacle("wall1", " #", 0, 0, this.width, 1, false);
        Obstacle wall2 = new Obstacle("wall2", "#", 0, 0, 1, this.height, false);

        this.obstacles.add(wall1);
        this.obstacles.add(wall2);
        setObstacles();
    }

    public void setObstacles() {
        for (Obstacle obstacle : obstacles) {
            int width = obstacle.getWidth();
            int height = obstacle.getHeight();
            Coordinates pivot = obstacle.getPivot();

            for (int x = pivot.getRowIndex(); x < pivot.getRowIndex() + height; x++) {
                for (int y = pivot.getColumnIndex(); y < pivot.getColumnIndex() + width; y++) {
                    this.board[x][y] = obstacle.getSymbol();
                }
            }
        }
    }

    public void printBoard() {
        StringBuilder boardBuilder = new StringBuilder();

        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                if (x == player.getCoordinates().getRowIndex() && y == player.getCoordinates().getColumnIndex()) {
                    boardBuilder.append(player.getSymbol());
                } else if (x == mentor.getCoordinates().getRowIndex() && y == mentor.getCoordinates().getColumnIndex()) {
                    boardBuilder.append(mentor.getSymbol());
                } else if (player.getCoordinates().getRowIndex() == mentor.getCoordinates().getRowIndex()
                        && player.getCoordinates().getColumnIndex() == mentor.getCoordinates().getColumnIndex()) {
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
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" 
                         + "|k - ask about knowledge amount |l - make consultation | m - try yourself with quality game |\n"
                         + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
    }
}