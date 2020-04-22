
public class Item extends GameObject{
    
    private int bonus;
    private Food food;
    private Weapon weapon;
    
    public Item(int bonus, Food food) {
        this.bonus = bonus;
        this.food = food;
    }

    public Item(int bonus, Weapon weapon) {
        this.bonus = bonus;
        this.weapon = weapon;
    }

}