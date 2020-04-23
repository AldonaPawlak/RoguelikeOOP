import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

class Game extends KeyAdapter {

    private Player player;
    private final int width = 20;
    private final int height = 20;
    private List<Obstacle> obstacles;
    private String[][] board = new String[width][height];

    public Game() {
        this.player = new Player("player", " @", 5, 5);
        this.obstacles = new ArrayList<>();
        createObstacles();
    }

    @Override
    public void keyPressed(KeyEvent event) {

        char ch = event.getKeyChar();

        System.out.println((int) ch);

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
        }
        System.out.println(player.getCoord().toString());
        printBoard();
    }

    public boolean isPlayerInRange(Obstacle obstacle, Coordinates coordinates) {
        int width = obstacle.getWidth();
        int height = obstacle.getHeight();
        Coordinates pivot = obstacle.getPivot();
        int x = this.player.getCoord().getX() + coordinates.getX();
        int y = this.player.getCoord().getY() + coordinates.getY();

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
        Obstacle wall1 = new Obstacle(new Coordinates(0, 0), width, 1, " #");
        Obstacle wall2 = new Obstacle(new Coordinates(0, 0), 1, height, "#");

        this.obstacles.add(wall1);
        this.obstacles.add(wall2);
        printObstacles(this.board);
    }

    public void printObstacles(String[][] board) {
        for (Obstacle obstacle : obstacles) {
            int width = obstacle.getWidth();
            int height = obstacle.getHeight();
            Coordinates pivot = obstacle.getPivot();

            for (int i = pivot.getX(); i < pivot.getX() + height; i++) {
                for (int j = pivot.getY(); j < pivot.getY() + width; j++) {
                    board[i][j] = obstacle.getSymbol();
                }
            }
        }
    }

    public void printBoard() {
        // String[][] board = new String[width][height];
        // board[this.player.getCoord().getX()][this.player.getCoord().getY()] =
        // player.getSymbol();

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (i == player.getCoord().getX() && j == player.getCoord().getY()) {
                    System.out.print(player.getSymbol());
                } else if (board[i][j] != null) {
                    System.out.print(board[i][j]);
                } else {
                    System.out.print(" .");
                }
            }
            System.out.println();
        }
    }
}