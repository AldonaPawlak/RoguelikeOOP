
public class Statistics {
    private int health;
    private int strength;
    private int inteligence;
    private int happiness;
    private int knowledge;

    public Statistics(int health, int strength, int inteligence, int happiness){
        this.health = health;
        this.strength = strength;
        this.inteligence = inteligence;
        this.happiness = happiness;
        this.knowledge = (strength * inteligence) + happiness;
    }

    public void setHealth(int healthValue){
        this.health = healthValue;
    }
    public int getHealth(){
        return health;
    }

    public void setStrength(int strengthValue){
        this.strength= strengthValue;
    }
    public int getStrength(){
        return strength;
    }

    public void setInteligence(int inteligenceValue){
        this.inteligence = inteligenceValue;
    }
    public int getInteligence(){
        return inteligence;
    }

    public void setHappiness(int happinessValue){
        this.happiness = happinessValue;
    }
    public int getHappiness(){
        return happiness;
    }

    public void countKnowledge(){
        this.knowledge = (strength * inteligence) + happiness;
    }
    public int getKnowledge(){
        return knowledge;
    }
}