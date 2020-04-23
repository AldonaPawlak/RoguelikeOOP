
public class Item extends GameObject{
    
    private int bonus;
    private Food food;
    private Weapon weapon;
    
    public Item(String name, String symbol, int rowIndex, int columnIndex, int bonus, Food food) {
        super(name, symbol, rowIndex, columnIndex);
        this.bonus = bonus;
        this.food = food;
    }

    public Item(String name, String symbol, int rowIndex, int columnIndex, int bonus, Weapon weapon) {
        super(name, symbol, rowIndex, columnIndex);
        this.bonus = bonus;
        this.weapon = weapon;
    }

}