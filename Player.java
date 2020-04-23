
public class Player extends Character {
    private Inventory inventory;

    public Player(String name, String symbol, int x, int y) {
        super(name, symbol, x, y);
        this.inventory = new Inventory();
    }

    public void move(Coordinates direction) {
        int x = this.coordinates.getX() + direction.getX();
        int y = this.coordinates.getY() + direction.getY();

        this.coordinates = new Coordinates(x, y);
    }
}