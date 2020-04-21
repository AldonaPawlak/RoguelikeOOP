
public abstract class Character {
    protected String name;
    protected Coordinates coord;
    protected Statistics statistics;

    public Character(String name){
        this.name = name;
    }

    public abstract void setName(String name);


    public abstract String getName();


    public abstract void setStatistics(int health, int strength, int inteligence);


    public abstract Statistics getStatistics();
}