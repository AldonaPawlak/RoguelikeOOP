
public abstract class Character {
    protected String name;
    protected Coordinates coord;
    protected Statistics statistics;

    public Character(){

    }

    public abstract void setName(String name);


    public abstract String getName();


    public abstract void setStatistics();


    public abstract Statistics getStatistics();
}