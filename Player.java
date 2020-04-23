
public class Player extends Character {
    private String playerName;
    private Coordinates playerCoordinates;
    private String playerSymbol;
    private Statistics playerStatistics;

    public Player(String name, String playerSymbol, int xCoordinate, int yCoordinate) {
        super(name);
        this.playerCoordinates = new Coordinates(xCoordinate, yCoordinate);
        this.playerName = name;
        this.playerSymbol = playerSymbol;
    }

    public void move(Coordinates direction) {
        System.out.println(direction.toString());
        int x = this.playerCoordinates.getX() + direction.getX();
        int y = this.playerCoordinates.getY() + direction.getY();

        this.playerCoordinates = new Coordinates(x, y);
    }

    public void setName(String playerName){
        this.playerName = playerName;
    }

    public String getName(){
        return playerName;
    }

    public void setStatistics(int health, int strength, int inteligence, int happiness){
        this.playerStatistics = new Statistics(health, strength, inteligence, happiness);
    }

    public Statistics getStatistics(){
        return playerStatistics;
    }

    public Coordinates getCoord() {
        return this.playerCoordinates;
    }

    public String getSymbol() {
        return this.playerSymbol;
    }
}