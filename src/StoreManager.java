import java.util.HashMap;

public class StoreManager {
    //Should it be static?
    private static Inventory inventory;

    public StoreManager(Inventory inv){
        inventory = inv;
    }

    //Should I change it to checkStock?
    public int getStock(Product product){
        return 0;
    }

    public boolean processTransaction(HashMap shoppingList){
        return false;
    }
}
