
public abstract class GameObject {
    protected Coordinates coordinates;
    private String symbol;
    private String name;

    public GameObject(String name, String symbol, int xCoordinate, int yCoordinate){
        this.name = name;
        this.symbol = symbol;
        this.coordinates = new Coordinates(xCoordinate, yCoordinate);

    }

    public void setSymbol(String symbol){
        this.symbol = symbol;
    }
    public String getSymbol(){
        return symbol;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;

    }
}