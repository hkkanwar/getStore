package StoreClass;
/**
 * @author Harsimran Kanwar 101143556,
 * @author Hussein Elmokdad 101171490
 * @version 1.0
 */

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

/**
 * Inventory Class
 * */
public class Inventory {

    private HashMap<Product, Integer> productQuant;

    /** Default constructor for Inventory */
    public Inventory(){
        //icons
        ImageIcon applesImage = new ImageIcon(new ImageIcon("src/StoreClass/Apples.jpg").getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));
        ImageIcon orangesImage = new ImageIcon(new ImageIcon("src/StoreClass/Oranges.jpg").getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));
        ImageIcon lemonsImage = new ImageIcon(new ImageIcon("src/StoreClass/Lemons.jpg").getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));
        ImageIcon bananasImage = new ImageIcon(new ImageIcon("src/StoreClass/Bananas.jpg").getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));
        ImageIcon kiwiImage = new ImageIcon(new ImageIcon("src/StoreClass/Kiwi.jpg").getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));
        ImageIcon strawberriesImage = new ImageIcon(new ImageIcon("src/StoreClass/Strawberries.jpg").getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));
        ImageIcon watermelonsImage = new ImageIcon(new ImageIcon("src/StoreClass/Watermelons.jpg").getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));
        Product apple = new Product("Apple",01,0.5, applesImage);
        Product orange = new Product("Orange",02,1.2, orangesImage);
        Product lemon = new Product("Lemon",03,0.8, lemonsImage);
        Product banana = new Product("Banana",04,0.3, bananasImage);
        Product kiwi = new Product("Kiwi",05,2.3, kiwiImage);
        Product straberry = new Product("Strawberry",06,0.1, strawberriesImage);
        Product watermelon = new Product("Watermelon",07,1.0, watermelonsImage);
        productQuant = new HashMap<Product, Integer>();
        addProduct(apple,42);
        addProduct(orange,16);
        addProduct(lemon,15);
        addProduct(banana,30);
        addProduct(kiwi,24);
        addProduct(straberry,64);
        addProduct(watermelon,9);
    }

    /** Gets the quantity of stock of a given product
     * @param productId     int value of the id for the product
     * @return quantity of stock
     */
    public int getStock(int productId){
        for(Product key: productQuant.keySet()){
            if(key.getId() == productId){
                return productQuant.get(key);
            }
        }
        return 0;
    }

    /** Gets the stock of product given productId
     * @param productId     int value of the id for the product
     * @return product object of given id
     */
    public Product getProduct(int productId){
        for(Product key: productQuant.keySet()){
            if(key.getId() == productId){
                return key;
            }
        }
        return null;
    }

    /** Adds product to hashmap. The product is stored as the key and
     * quantity is stored as the value. In case of duplicate, it will update
     * quantity of said product.Returns nothing
     * @param product   product object to add
     * @param quantity  int value for amount to add
     */
    public void addProduct(Product product, int quantity){
        if(productQuant.containsKey(product)){
            productQuant.replace(product, productQuant.get(product) + quantity);
        }
        else productQuant.put(product, quantity);
    }

    /** Removes product quantity from HashMap given ProductID and quantity to be removed.
     * If the quantity is 0, it will stay 0. Returns nothing.
     * @param productId     int value of id for product object
     * @param quantity      int value of amount to remove
     * */
    public void removeProduct(int productId, int quantity) {
        for(Product key: productQuant.keySet()){
            if(key.getId() == productId){
                productQuant.replace(key, (productQuant.get(key) - quantity));
                if (productQuant.get(key) < 0) productQuant.replace(key, 0);
            }
        }
    }

    /**
     * Get all products in Inventory
     * @return productQuant
     */
    public HashMap<Product, Integer> getProductQuant() {
        return productQuant;
    }
}
