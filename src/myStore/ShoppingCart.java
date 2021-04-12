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

    /**
     * Gets the quantity/stock of a product in the cart
     * @param product the object of type Product to check for
     * @return the quantity of the product
     */
    public int getStock(Product product){
        for(Product productInCart: cart.keySet()){
            if (productInCart.equals(product)){
                return cart.get(product);
            }
        }
        return 0;
    }

    /** Gets the quantity of stock of a given product
     * @param productId     int value of the id for the product
     * @return quantity of stock
     */
    public int getProductQuantity(int productId){
        for(Product key: cart.keySet()){
            if(key.getId() == productId){
                return cart.get(key);
            }
        }
        return 0;
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
