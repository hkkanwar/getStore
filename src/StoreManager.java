// Harsimran Kanwar 101143556
// Hussein Elmokdad 101171490

import java.util.HashMap;

public class StoreManager {
    private static Inventory inventory;

    public StoreManager(){
        inventory = new Inventory();
    }

    /**
     * Gets the number of available stock for a product
     *
     * @param product to check for
     * @return number of stock
     */
    public int checkStock(Product product){ return inventory.getStock(product.getID()); }

    /**
     * Processes the transaction by removing a specific quantity of items
     * from the inventory. Returns -1 if the quantity of an item is more
     * than the available stock
     *
     * @param shoppingList with the items to process
     * @return the total number of processed items.
     */
    public int processTransaction(HashMap<Product, Integer> shoppingList) {
        int sum = 0;
        for (Product item : shoppingList.keySet()) {
            if (shoppingList.get(item) > inventory.getStock(item.getID())) return -1;
        }
        for (Product item : shoppingList.keySet()) {
            inventory.removeProduct(item.getID(), shoppingList.get(item));
            sum += shoppingList.get(item);
        }
        return sum;
    }

}
