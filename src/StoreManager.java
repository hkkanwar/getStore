// Harsimran Kanwar 101143556
// Hussein Elmokdad 101171490

import java.util.ArrayList;
import java.util.HashMap;

public class StoreManager {
    private static Inventory inventory;
    private int cartID;
    private ArrayList<ShoppingCart> shoppingCartArray;

    /**
     *
     */
    public StoreManager(){
        inventory = new Inventory();
        shoppingCartArray = new ArrayList<ShoppingCart>();
        cartID = -1;
    }

    /**
     * Gets the number of available stock for a product
     *
     * @param product to check for
     * @return number of stock
     */
    public int checkStock(Product product){ return inventory.getStock(product.getId()); }

    /**
     * Processes the transaction by removing a specific quantity of items
     * from the inventory. Returns -1 if the quantity of an item is more
     * than the available stock
     *
     * @param shoppingList with the items to process
     * @return the total number of processed items.
     */
    public int processTransaction(HashMap<Product,Integer> shoppingList) {
        int sum = 0;
        for (Product item : shoppingList.keySet()) {
            if (shoppingList.get(item) > inventory.getStock(item.getId())) return -1;
        }
        for (Product item : shoppingList.keySet()) {
            inventory.removeProduct(item.getId(), shoppingList.get(item));
            sum += shoppingList.get(item);
        }
        return sum;
    }

    /**
     *
     * @param product
     * @param quantity
     */
    public void addItemToCart(Product product, int quantity, int cartID){
        ShoppingCart shoppingCart = shoppingCartArray.get(cartID);
        HashMap<Product, Integer> cart = shoppingCart.getCart();
        //Check if there is enough stock in inventory
        checkStock(product);
        boolean isDuplicate = false;
        for(Product item: cart.keySet()){
            if(item.getId() == product.getId()){
                cart.replace(item, (cart.get(item)+quantity));
                isDuplicate=true;
            }
        }
        if(!isDuplicate){
            cart.put(product,quantity);
        }

        //Remove items from inventory
    }

    /**
     *
     * @param product
     * @param quantity
     */
    public void removeItemFromCart(Product product, int quantity){
        ShoppingCart shoppingCart = shoppingCartArray.get(cartID);
        HashMap<Product, Integer> cart = shoppingCart.getCart();
        for(Product item: cart.keySet()){
            if(item.getId() == product.getId()){
                cart.replace(item, (cart.get(item) - quantity));
                if (cart.get(item) <= 0) cart.remove(item); //Should we remove it or set it to 0?
            }
        }
        //Add items back to inventory
    }

    /**
     *
     * @return
     */
    public int assignNewCartID(){
        cartID++;
        return cartID;
    }

}
