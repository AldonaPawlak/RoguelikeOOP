
public class Player extends Character {
    private String name;
    private Coordinates coord;
    private String symbol = "@";
    private Statistics statistics;

    public Player(String name, String playerSymbol, int xCoordinates, int yCoordinates) {
        super(name);
        this.coord = new Coordinates(xCoordinates, yCoordinates);
        this.name = name;
        this.symbol = playerSymbol;
        this.statistics = new Statistics(0, 0, 0);
    }

    public void move(Coordinates direction) {
        System.out.println(direction.toString());
        int x = this.coord.getX() + direction.getX();
        int y = this.coord.getY() + direction.getY();

        this.coord = new Coordinates(x, y);
    }

    public void setName(String playerName){
        this.name = playerName;
    }

    public String getName(){
        return name;
    }

    public void setStatistics(int health, int strength, int inteligence){
        this.statistics = new Statistics(health, strength, inteligence);
    }

    public Statistics getStatistics(){
        return statistics;
    }

    public Coordinates getCoord() {
        return this.coord;
    }

    public String getSymbol() {
        return this.symbol;
    }
}