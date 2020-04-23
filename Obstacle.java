
public class Obstacle extends GameObject{
    protected Coordinates pivot;
    private int width;
    private int height;

    public Obstacle(String name, String symbol, int xCoordinate, int yCoordinate, int width, int height) {
        super(name, symbol, xCoordinate, yCoordinate);
        this.pivot = new Coordinates(xCoordinate, yCoordinate);
        this.width = width;
        this.height = height;
    }

    public Coordinates getPivot() {
        return pivot;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}