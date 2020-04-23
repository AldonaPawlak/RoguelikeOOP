
public class Mentor extends Character{
    private String enemyName;
    private Coordinates enemyCoordinates;
    private String enemySymbol;
    private Statistics enemyStatistics;

    public Mentor(String name, String enemySymbol, int xCoordinate, int yCoordinate) {
        super(name);
        this.enemyCoordinates = new Coordinates(xCoordinate, yCoordinate);
        this.enemyName = name;
        this.enemySymbol = enemySymbol;
    }

    public void setName(String enemyName){
        this.enemyName = enemyName;
    }

    public String getName(){
        return enemyName;
    }

    public void setStatistics(int health, int strength, int inteligence, int happiness){
        this.enemyStatistics = new Statistics(health, strength, inteligence, happiness);
    }

    public Statistics getStatistics(){
        return enemyStatistics;
    }

    public Coordinates getCoord() {
        return this.enemyCoordinates;
    }

    public String getSymbol() {
        return this.enemySymbol;
    }

}