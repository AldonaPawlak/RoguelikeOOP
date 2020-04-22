
public abstract class Character /*extends GameObject*/ {
    protected String name;
    protected Statistics statistics;

    public Character(String name){
        this.name = name;
    }

    public abstract void setName(String name);


    public abstract String getName();


    public abstract void setStatistics(int health, int strength, int inteligence, int happiness);


    public abstract Statistics getStatistics();
}