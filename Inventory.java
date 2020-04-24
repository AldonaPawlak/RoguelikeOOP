import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private List<Item> inventory;

    public Inventory() {
        this.inventory = new ArrayList<>();
    }

    public void addItemToInventory(Item item){
        inventory.add(item);
    }

    public void printInventory(){
        System.out.println("Inventory:");
        for (int i = 0; i < inventory.size(); i++){
            System.out.println(inventory.get(i).getName());
        }
    }

}