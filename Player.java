import java.util.ArrayList;

public class Player {
    private String name;
    private Coordinates coord;
    private String symbol = "@";
    private ArrayList<GameObject> inventory;

    public Player() {
        this.coord = new Coordinates(5,5);
    }

    public void move(Coordinates direction) {
        System.out.println(direction.toString());
        int x = this.coord.getX() + direction.getX();
        int y = this.coord.getY() + direction.getY();

        this.coord = new Coordinates(x, y);
    }

    public Coordinates getCoord() {
        return this.coord;
    }

    public String getSymbol() {
        return this.symbol;
    }
}