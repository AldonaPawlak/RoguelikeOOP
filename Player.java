
public class Player extends Character {
    private Inventory inventory;

    public Player() {
        this.inventory = new Inventory();
    }

    public void move(Coordinates direction) {
        int x = this.playerCoordinates.getX() + direction.getX();
        int y = this.playerCoordinates.getY() + direction.getY();

        this.playerCoordinates = new Coordinates(x, y);
    }
}