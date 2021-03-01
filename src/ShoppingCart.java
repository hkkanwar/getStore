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
     * @return cart
     */
    public HashMap<Product, Integer> getCart() {
        return cart;
    }

    /** Adds product to cart. The product is stored as the key and
     * quantity is stored as the value. In case of duplicate, it will update
     * quantity of said product.Returns nothing
     * @param product   Product object to add in cart
     * @param quantity  int value of amount to add
     */
    public void addItem(Product product, int quantity){
        boolean duplicate = false;
        for(Product key: cart.keySet()){
            if(key.getId() == product.getId()){
                cart.replace(key,(cart.get(key)+quantity));
                duplicate=true;
            }
        }
        if(!duplicate){
            cart.put(product,quantity);
        }
    }

    /** Removes product quantity from cart HashMap given ProductID and quantity to be removed.
     * If the quantity is 0, it will stay 0. Returns nothing.
     * @param productId    int value of id of Product object to remove
     * @param quantity     int value of amount to remove
     * */
    public void removeItem(int productId, int quantity) {
        for(Product key: cart.keySet()){
            if(key.getId() == productId){
                cart.replace(key, (cart.get(key) - quantity));
                if (cart.get(key) < 0) cart.replace(key, 0);
            }
        }
    }


}
