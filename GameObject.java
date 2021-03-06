
public abstract class GameObject {
    protected Coordinates coordinates;
    private String symbol;
    private String name;
    private String color;

    public GameObject(String name, String symbol, int rowIndex, int columnIndex){
        this.name = name;
        this.symbol = symbol;
        this.coordinates = new Coordinates(rowIndex, columnIndex);
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public Coordinates getCoordinates() {
        return this.coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public boolean getCanPass() {
        return true;
    }
}