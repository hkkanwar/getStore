package StoreClass;
/**
 * @author Harsimran Kanwar 101143556,
 * @author Hussein Elmokdad 101171490
 * @version 1.0
 */

import java.util.HashMap;

public class ShoppingCart {
    private HashMap<Product, Integer> cart;

    /**
     * Default Constructor for ShoppingCart class
     */
    public ShoppingCart(){cart = new HashMap<Product, Integer>();}

    /**
     * Fetches all items in cart
     * @return HashMap<Product, Integer> cart
     */
    public HashMap<Product, Integer> getCart() {
        return cart;
    }

}
