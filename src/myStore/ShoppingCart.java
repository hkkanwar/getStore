package myStore;
/**
 * @author Harsimran Kanwar 101143556,
 * @author Hussein Elmokdad 101171490
 * @version 1.0
 */

import java.util.HashMap;

public class ShoppingCart {
    private HashMap<Product, Integer> cart;
    //new stuff
    private static StoreManager sm; // Should we make this static since they all share the same store manager?
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


    public int getProductQuantity(Product product){
        for(Product productInCart: cart.keySet()){
            if (productInCart.equals(product)){
                return cart.get(product);
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

    public int getNumOfProducts(){
        // Do they want the number of products or the sum of quantities for each product?
        return 0; // for now
    }

}
