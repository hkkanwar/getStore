// Harsimran Kanwar 101143556
// Hussein Elmokdad 101171490

import java.util.HashMap;

public class Inventory {

    public HashMap<Product, Integer> productQuant; //Change back to private

    /**
     *
     */
    public Inventory(){
        Product apple = new Product("Apple",01,0.5);
        Product orange = new Product("Orange",02,1.2);
        Product lemon = new Product("Lemon",03,0.8);
        productQuant = new HashMap<Product, Integer>();
        addProduct(apple,10);
        addProduct(orange,5);
        addProduct(lemon,5);
    }

    /** Gets the quantity of stock of a given product
     * @param productId
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
     * @param productId
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
     * @param product, quantity
     */
    public void addProduct(Product product, int quantity){
        if(productQuant.containsKey(product)){
            productQuant.replace(product, productQuant.get(product) + quantity);
        }
        else productQuant.put(product, quantity);
    }

    /** Removes product quantity from HashMap given ProductID and quantity to be removed.
     * If the quantity is 0, it will stay 0. Returns nothing.
     * @param productId, quantity
     * */
    public void removeProduct(int productId, int quantity) { //We need to update the docstring
        for(Product key: productQuant.keySet()){
            if(key.getId() == productId){
                productQuant.replace(key, (productQuant.get(key) - quantity));
                if (productQuant.get(key) < 0) productQuant.replace(key, 0);
            }
        }
    }

    /**
     *
     * @return
     */
    public HashMap<Product, Integer> getProductQuant() {
        return productQuant;
    }
}
