import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

class Game extends KeyAdapter {

    private Player player;
    private Mentor mentor;
    private final int width = 80;
    private final int height = 40;
    private List<Obstacle> obstacles;
    private List<Item> items;
    private String[][] board = new String[height][width];

    public Game() {
        this.player = new Player("player", " @", 5, 5);
        this.mentor = new Mentor("mentor", " &", 7, 7);
        player.setStatistics(3, 0, 0, 100);
        mentor.setStatistics(100, 100, 100, 100);
        this.obstacles = new ArrayList<>();
        this.items = new ArrayList<>();
        createObstacles();
        createItems();
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
        isItemInteraction();
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
        Obstacle wall2 = new Obstacle("wall2", "#",0, 0, 1, this.height, false);
        Obstacle wall3 = new Obstacle("wall3", "# ", 39, 0, this.width, 1, false);
        Obstacle wall4 = new Obstacle("wall4", " #", 0, 79, 1, this.height -1, false);
        Obstacle kitchenWallTop = new Obstacle("kitchenWallTop", " #", 20, 65, 15, 1, false);
        Obstacle kitchenWallLeft = new Obstacle("kitchenWallLeft", " #", 20, 63, 1, 19, false);
        Obstacle mentorsRoomLeft = new Obstacle("mentorsRoomLeft", " #", 20, 53, 1, 19, false);
        Obstacle staffRoomLeft = new Obstacle("staffRoomLeft)", " #", 15, 41, 1, 24, false);
        Obstacle brickRoomLeft = new Obstacle("brickRoomLeft)", " #", 12, 17, 1, 27, false);
        Obstacle brickRoomLeft2 = new Obstacle("brickRoomLeft2", " #", 0, 17, 1, 11, false);
        Obstacle brickRoomTop = new Obstacle("brickRoomTop", " #", 14, 18, 10, 1, false);
        Obstacle brickRoomTop2 = new Obstacle("brickRoomTop2", " #", 14, 29, 13, 1, false);
        Obstacle staffRoomTop = new Obstacle("staffRoomTop", " #", 20, 42, 5, 1, false);
        Obstacle staffRoomTop2 = new Obstacle("staffRoomTop2", " #", 20, 48, 5, 1, false);
        Obstacle meetingRoomTop = new Obstacle("meetingRoomTop", " #", 20, 54, 3, 1, false);
        Obstacle meetingRoomTop2 = new Obstacle("meetingRoomTop2", " #", 20, 58, 6, 1, false);
        Obstacle corridorWallTop = new Obstacle("corridorWallTop", " #", 1, 17, 33, 5, false);
        Obstacle stairs = new Obstacle("stairs", " #", 1, 50, 15, 14, false);
        Obstacle toiletTop = new Obstacle("toiletTop", " #", 1, 65, 14, 7, false);
        Obstacle toiletMiddle = new Obstacle("toiletMiddle", " #", 8, 70, 1, 8, false);
        Obstacle toiletMiddle2 = new Obstacle("toiletMiddle2", " #", 17, 70, 1, 3, false);
        Obstacle toiletMiddle3 = new Obstacle("toiletMiddle3", " #", 14, 66, 4, 1, false);

        this.obstacles.add(wall1);
        this.obstacles.add(wall2);
        this.obstacles.add(wall3);
        this.obstacles.add(wall4);
        this.obstacles.add(kitchenWallTop);
        this.obstacles.add(kitchenWallLeft);
        this.obstacles.add(mentorsRoomLeft);
        this.obstacles.add(staffRoomLeft);
        this.obstacles.add(brickRoomLeft);
        this.obstacles.add(brickRoomLeft2);
        this.obstacles.add(brickRoomTop);
        this.obstacles.add(brickRoomTop2);
        this.obstacles.add(staffRoomTop);
        this.obstacles.add(staffRoomTop2);
        this.obstacles.add(meetingRoomTop);
        this.obstacles.add(meetingRoomTop2);
        this.obstacles.add(corridorWallTop);
        this.obstacles.add(stairs);
        this.obstacles.add(toiletTop);
        this.obstacles.add(toiletMiddle);
        this.obstacles.add(toiletMiddle2);
        this.obstacles.add(toiletMiddle3);
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

    public void createItems(){
        Item filler = new Item("filler", " #", 0, 0, 0, Weapon.BOOK);
        Item tangerine = new Item("tangerine", " ð", 26, 75, 2, Food.TANGERINE);
        Item cofee = new Item("cofee", " µ", 23, 70, 5, Food.COFFEE);
        Item pistol = new Item("pistol", " ¬", 17, 77, 3, Weapon.PISTOL);

        items.add(filler);
        items.add(tangerine);
        items.add(cofee);
        items.add(pistol);
        setItems();
    }

    public void setItems() {
        for (Item item : items) {
            int x = item.getCoordinates().getRowIndex();
            int y = item.getCoordinates().getColumnIndex();
            this.board[x][y] = item.getSymbol();
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
                } else if (board[x][y] != null) {
                    boardBuilder.append(board[x][y]);
                } else {
                    boardBuilder.append(" .");
                }
            }
            boardBuilder.append("\n");
        }
        boardBuilder.append("|Health: " + player.getStatistics().getHealth() + "   | " 
                        + "Strength: " + player.getStatistics().getStrength() + "   | " 
                        + "Inteligence: " + player.getStatistics().getInteligence() + "   | " 
                        + "Happiness: " + player.getStatistics().getHappiness() + "   | " 
                        + "Knowledge: " + player.getStatistics().getKnowledge());

        System.out.println(boardBuilder.toString());
    }

    public void isItemInteraction(){
        for (int i = 0; i < items.size(); i++){
            Item item = items.get(i);
            if (player.getCoordinates().getRowIndex() == item.getCoordinates().getRowIndex()
            && player.getCoordinates().getColumnIndex() == item.getCoordinates().getColumnIndex()){
                if (item.getSymbol().equals(" ð")){
                    player.getStatistics().setStrength(player.getStatistics().getStrength() + 2);
                    int x = item.getCoordinates().getRowIndex();
                    int y = item.getCoordinates().getColumnIndex();
                    this.board[x][y] = " .";
                    items.remove(item);
                }
                if (item.getSymbol().equals(" µ")){
                    player.getStatistics().setStrength(player.getStatistics().getStrength() + 5);
                    int x = item.getCoordinates().getRowIndex();
                    int y = item.getCoordinates().getColumnIndex();
                    this.board[x][y] = " .";
                    items.remove(item);
                }
                if (item.getSymbol().equals(" ¬")){
                    player.addToInventory(item);
                    int x = item.getCoordinates().getRowIndex();
                    int y = item.getCoordinates().getColumnIndex();
                    this.board[x][y] = " .";
                    items.remove(item);
                }
            }
        }
    }
}