
public class Enemy extends Character{
    private String name;
    private Coordinates coord;
    private String symbol = "#";
    private Statistics statistics;

    public Enemy(String name, String enemySymbol, int xCoordinates, int yCoordinates) {
        super(name);
        this.coord = new Coordinates(xCoordinates, yCoordinates);
        this.name = name;
        this.symbol = enemySymbol;
        this.statistics = new Statistics(0, 0, 0);
    }

    public void setName(String enemyName){
        this.name = enemyName;
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