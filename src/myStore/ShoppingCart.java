package myStore;
/**
 * @author Harsimran Kanwar 101143556,
 * @author Hussein Elmokdad 101171490
 * @version 1.0
 */

import java.util.HashMap;

public class ShoppingCart implements ProductStockContainer{
    private HashMap<Product, Integer> cart;
    private static StoreManager sm;
    private int cartID;

    /**
     * Constructor for ShoppingCart class
     */
    public ShoppingCart(StoreManager sm, int cartID){
        cart = new HashMap<Product, Integer>();
        this.sm = sm;
        this.cartID = cartID;
    }

    /**
     * Fetches all items in cart
     * @return HashMap<Product, Integer> cart
     */
    public HashMap<Product, Integer> getCart() {
        return cart;
    }


    /** Gets the quantity of stock of a given product
     * @param product    product object
     * @return quantity of stock
     */
    public int getProductQuantity(Product product){
        int quant = 0;
        if (cart.containsKey(product)){
            quant = cart.get(product);
        }
        return quant;
    }

    /**
     * Adds item(s) to the cart and updates inventory accordingly.
     * Returns nothing
     * @param product   Product object to add to cart
     * @param quantity  int value of amount to add to cart
     */
    public void addProductQuantity(Product product, int quantity){
        sm.addItemToCart(product, quantity, cartID);
    }

    /**
     * Removes item(s) from the cart and updates inventory accordingly.
     * Returns nothing
     * @param product   Product object to remove
     * @param quantity  int value of amount needed to remove from cart
     */
    public void removeProductQuantity(Product product, int quantity){
        sm.removeItemFromCart(product, quantity, cartID);
    }

    /** Returns the total number of unique products
     * in cart.
     * @return cart.size()  int value of size of cart HashMap
     * */
    public int getNumOfProducts(){
        return cart.size();
    }

}
