
public class Player {
    Coordinates coord;
    String symbol = "\ud83d\udd7a";

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