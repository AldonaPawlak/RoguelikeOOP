
public class Player extends Character {
    private Inventory inventory;

    public Player(String name, String symbol, int rowIndex, int columnIndex) {
        super(name, symbol, rowIndex, columnIndex);
        this.inventory = new Inventory();
    }

    public void move(Coordinates direction) {
        int rowIndex = this.coordinates.getRowIndex() + direction.getRowIndex();
        int columnIndex = this.coordinates.getColumnIndex() + direction.getColumnIndex();

        this.coordinates = new Coordinates(rowIndex, columnIndex);
    }

    public void printInventory(){
        inventory.printInventory();
    }
}