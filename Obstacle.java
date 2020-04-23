
public class Obstacle extends GameObject{
    private Coordinates pivot;
    private int width;
    private int height;
    private boolean canPass;

    public Obstacle(String name, String symbol, int xCoordinate, int yCoordinate, int width, int height, boolean canPass) {
        super(name, symbol, xCoordinate, yCoordinate);
        this.pivot = new Coordinates(xCoordinate, yCoordinate);
        this.width = width;
        this.height = height;
        this.canPass = canPass;
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

    public boolean getCanPass(){
        return this.canPass;
    }
    
    public void setCanPass(boolean can){
        this.canPass = can;
    }

    public void use(Player player) {
        
    }
}