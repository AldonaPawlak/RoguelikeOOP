
public class Statistics {
    private int health;
    private int strength;
    private int inteligence;
    private int attack;

    public Statistics(int health, int strength, int inteligence){
        this.health = health;
        this.strength = strength;
        this.inteligence = inteligence;
        this.attack = strength * inteligence;
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

    public void countAttack(){
        this.attack = strength * inteligence;
    }
    public int getAttack(){
        return attack;
    }
}