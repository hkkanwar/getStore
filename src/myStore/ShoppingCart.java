package myStore;
/**
 * @author Harsimran Kanwar 101143556,
 * @author Hussein Elmokdad 101171490
 * @version 1.0
 */

import java.util.HashMap;

public class ShoppingCart implements ProductStockContainer{
    private HashMap<Product, Integer> cart;
    //new stuff
    private static StoreManager sm; // Should we make this static since they all share the same store manager?go for it:)
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

    public void addProductQuantity(Product product, int quantity){
        sm.addItemToCart(product, quantity, cartID);
    }

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
