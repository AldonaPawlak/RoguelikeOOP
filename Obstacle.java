
public class Obstacle {
    private Coordinates pivot;
    private int width;
    private int height;
    private String symbol;

    public Obstacle(Coordinates pivot, int width, int height, String symbol) {
        this.pivot = pivot;
        this.width = width;
        this.height = height;
        this.symbol = symbol;
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

    public String getSymbol() {
        return symbol;
    }
}