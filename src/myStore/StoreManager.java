package myStore;
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
     * @return int number of stock
     */
    public int checkStock(Product product){ return inventory.getProductQuantity(product.getId()); }

    /**
     * Process the transaction by printing out a summary of the
     * user's cart
     * @param shoppingList the HashMap of the items to process
     * @param cartID the int ID of the shopping cart
     * @return the double price of all the quantities of items
     */
    public double processTransaction(HashMap<Product,Integer> shoppingList, int cartID) {
        double total = 0;
        System.out.println("Purchased items: ");
        for (Product item : shoppingList.keySet()){
            total += item.getPrice() * shoppingList.get(item);
            System.out.println(item.getName() + " - " + shoppingList.get(item));
        }
        System.out.println("Total: $" + total);
        return total;
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
            inventory.removeProductQuantity(product, quantity);
        }
    }

    /**
     * Removes item from shopping cart and updates inventory accordingly.
     * Returns nothing
     * @param product   Product object to remove
     * @param quantity  int value of amount needed to remove from cart
     * @param cartID    int value of shoppingCart id
     */
    public void removeItemFromCart(Product product, int quantity, int cartID){
        ShoppingCart shoppingCart = shoppingCartArray.get(cartID);
        HashMap<Product, Integer> cart = shoppingCart.getCart();
        int actualQuantity = 0;
        if (quantity > cart.get(product)) actualQuantity = cart.get(product);
        else actualQuantity = quantity;
        cart.replace(product, (cart.get(product) - quantity));
        if (cart.get(product) <= 0) cart.remove(product);
        inventory.addProductQuantity(product, actualQuantity);
    }

    /**
     * Returns a cart given its cartID
     * @return the int cart id
     */
    public HashMap<Product, Integer> getCart(int cartID){
        return shoppingCartArray.get(cartID).getCart();
    }

    /**
     *Assigns new id to shopping cart
     * @return cartIdCounter
     */
    public int assignNewCartID(){
        cartIdCounter++;
        ShoppingCart newCart = new ShoppingCart(this, cartIdCounter);
        shoppingCartArray.add(newCart);
        return cartIdCounter;
    }

    /**
     * Prints and returns a list of all the items in inventory
     * @return the ArrayList<Product> productsArray
     */
    public ArrayList<Product> showInventory(){
        ArrayList<Product> productsArray = new ArrayList<Product>(); //Products in inventory
        for(Product item : inventory.getProductQuant().keySet()){
            productsArray.add(item);
        }
        for(Product item: productsArray){
            System.out.println("(" + productsArray.indexOf(item) + ") " + item.getName() + " Stock: " +checkStock(item)  + ", price: $" + item.getPrice());
        }
        return productsArray;
    }

    /**
     * Returns and prints the contents of a cart
     * @param cartID    int value of cart id
     * @return ArrayList<Product> productsArray
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

    /**
     * Returns and prints the contents of a cart as a string
     * @param cartID    int value of cart id
     * @return ArrayList<String> productsArray
     */
    public ArrayList<String> cartItemsList(int cartID){
        ShoppingCart shoppingCart = shoppingCartArray.get(cartID);
        HashMap<Product, Integer> cart = shoppingCart.getCart();
        ArrayList<String> productsArray = new ArrayList<String>();
        int counter = 1;

        for(Product item: cart.keySet()){
            //sb = System.out.println("(" + productsArray.indexOf(item) + ") " + item.getName() + ", quantity: " + cart.get(item));
            productsArray.add(String.format("(%d) %s @%d................. $%.2f \n", counter, item.getName(),cart.get(item), (cart.get(item)* item.getPrice())));
            counter +=1;
        }
        return productsArray;
    }


    /**
     * Returns the items in the shopping cart back to the inventory
     * @param cartID the int representing the cart ID
     */
    public void returnItemsToInventory(int cartID){
        for (Product product : getCart(cartID).keySet()){
            inventory.addProductQuantity(product, getCart(cartID).get(product));
        }
    }

}
