
public abstract class Character extends GameObject {
    protected Statistics statistics;

    public Character(int health, int strength, int inteligence, int happiness){
        setStatistics(health, strength, inteligence, happiness);
    }

    public void setStatistics(int health, int strength, int inteligence, int happiness){
        this.statistics.setHealth(health);
        this.statistics.setStrength(strength);
        this.statistics.setInteligence(inteligence);
        this.statistics.setHappiness(happiness);
    }


    public Statistics getStatistics(){
        return statistics;
    }
}