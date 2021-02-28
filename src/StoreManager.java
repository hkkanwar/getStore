/**
 * @author Harsimran Kanwar 101143556,
 * @author Hussein Elmokdad 101171490
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.HashMap;

public class StoreManager {
    public static Inventory inventory; //Change back to private
    private int cartIdCounter;
    public ArrayList<ShoppingCart> shoppingCartArray; //Change back to private

    /**
     *
     */
    public StoreManager(){
        inventory = new Inventory();
        shoppingCartArray = new ArrayList<ShoppingCart>();
        cartIdCounter = -1;
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
        int sum = 0; //We need to remember to edit the docstring
        System.out.println("Purchased items: ");
        for (Product item : shoppingList.keySet()) {
            sum += shoppingList.get(item);
            System.out.println(item.getName() + " - " + shoppingList.get(item));
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
        if(quantity <= checkStock(product)){
            if(cart.containsKey(product)){
                cart.replace(product, cart.get(product) + quantity);
            }
            else cart.put(product, quantity);
            inventory.removeProduct(product.getId(), quantity);
        }
    }

    /**
     *
     * @param product
     * @param quantity
     */
    public void removeItemFromCart(Product product, int quantity, int cartID){
        ShoppingCart shoppingCart = shoppingCartArray.get(cartID);
        HashMap<Product, Integer> cart = shoppingCart.getCart();
        int actualQuantity = 0;
        if (quantity > cart.get(product)) actualQuantity = cart.get(product); //If the quantity the user inputs is greater than that in the cart, it will remove all the items of that product
        else actualQuantity = quantity;
        cart.replace(product, (cart.get(product) - quantity));
        if (cart.get(product) <= 0) cart.remove(product); //Should we remove it or set it to 0?
        inventory.addProduct(product, actualQuantity);
    }

    /**
     *
     * @return
     */
    public int assignNewCartID(){
        cartIdCounter++;
        ShoppingCart newCart = new ShoppingCart();
        shoppingCartArray.add(newCart);
        return cartIdCounter;
    }

    /**
     *
     */
    public ArrayList<Product> showInventory(){
        ArrayList<Product> productsArray = new ArrayList<Product>();
        for(Product item : inventory.getProductQuant().keySet()){
            productsArray.add(item);
        }
        for(Product item: productsArray){
            System.out.println(item.getName() + "(" + productsArray.indexOf(item) + ")");
        }
        return productsArray;
    }

}
