/**
 * @author Harsimran Kanwar 101143556,
 * @author Hussein Elmokdad 101171490
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.HashMap;

public class StoreManager {
    private static Inventory inventory;
    private int cartIdCounter;
    private ArrayList<ShoppingCart> shoppingCartArray;

    /**
     *Default constructor for StoreManager
     */
    public StoreManager(){
        inventory = new Inventory();
        shoppingCartArray = new ArrayList<ShoppingCart>();
        cartIdCounter = -1;
    }

    /**
     * Gets the number of available stock for a product
     * @param product   Product object to check for
     * @return number of stock
     */
    public int checkStock(Product product){ return inventory.getStock(product.getId()); }

    /**
     * Processes the transaction by removing a specific quantity of items
     * from the inventory. Returns -1 if the quantity of an item is more
     * than the available stock
     * @param shoppingList  ArrayList of  items to process
     * @return sum      int value of the total number of processed items.
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
     *Adds item to shopping cart and updates inventory accordingly.
     * Returns nothing
     * @param product   Product object to add to cart
     * @param quantity  int value of amount to add to cart
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
     *Removes item from shopping cart and updates inventory accordingly.
     * Returns nothing
     * @param product   Product object to remove
     * @param quantity  int value of amount needed to remove from cart
     * @param cartID    int value of shoppingCart id
     */
    public void removeItemFromCart(Product product, int quantity, int cartID){
        ShoppingCart shoppingCart = shoppingCartArray.get(cartID);
        HashMap<Product, Integer> cart = shoppingCart.getCart();
        int actualQuantity = 0;
        if (quantity > cart.get(product)) actualQuantity = cart.get(product); //If the quantity the user inputs is greater than that in the cart, it will remove all the items of that product
        else actualQuantity = quantity;
        cart.replace(product, (cart.get(product) - quantity));
        if (cart.get(product) <= 0) cart.remove(product); //Should we remove it or set it to 0? set to 0?
        inventory.addProduct(product, actualQuantity);
    }

    /**
     *Returns all items in cart
     * @return cartIdCounter
     */
    public HashMap<Product, Integer> getCart(int cartID){
        return shoppingCartArray.get(cartID).getCart(); //couldn't we just do super?
    }

    /**
     *Assigns new id to shopping cart
     * @return cartIdCounter
     */
    public int assignNewCartID(){
        cartIdCounter++;
        ShoppingCart newCart = new ShoppingCart();
        shoppingCartArray.add(newCart);
        return cartIdCounter;
    }

    /**
     * Returns a list of all the items in inventory
     * @return productsArray
     */
    public ArrayList<Product> showInventory(){
        ArrayList<Product> productsArray = new ArrayList<Product>(); //Products in inventory
        for(Product item : inventory.getProductQuant().keySet()){
            productsArray.add(item);
        }
        for(Product item: productsArray){
            System.out.println("(" + productsArray.indexOf(item) + ") " + item.getName() + " Stock: " +checkStock(item));
        }
        return productsArray;
    }

    /**
     * Returns and prints the contents of a cart
     * @param cartID    int value of cart id
     * @return productsArray
     */
    public ArrayList<Product> showCart(int cartID){
        ShoppingCart shoppingCart = shoppingCartArray.get(cartID);
        HashMap<Product, Integer> cart = shoppingCart.getCart();
        ArrayList<Product> productsArray = new ArrayList<Product>(); //Products in cart
        for(Product item : cart.keySet()){
            productsArray.add(item);
        }
        for(Product item: cart.keySet()){
            System.out.println("(" + productsArray.indexOf(item) + ") " + item.getName() + ", quantity: " + cart.get(item));
        }
        return productsArray;
    }

}
