// Harsimran Kanwar 101143556
// Hussein Elmokdad 101171490

import java.util.HashMap;

public class Inventory {

    public HashMap<Product, Integer> productQuant;

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
     * @return stockNum (quantity of stock) */
    public int getStock(int productId){
        int stockNum = 0;
        for(Product key: productQuant.keySet()){
            if(key.getId() == productId){
                stockNum = productQuant.get(key);
            }
        }
        return stockNum;
    }

    /** Gets the stock of product given productId
     * @param productId
     * @return productInfo (product object of given id)*/
    public Product getProduct(int productId){
        Product productInfo = null;
        for(Product key: productQuant.keySet()){
            if(key.getId() == productId){
                productInfo = key;
            }
        }
        return productInfo;
    }

    /** Adds product to hashmap. The product is stored as the key and
     * quantity is stored as the value. In case of duplicate, it will update
     * quantity of said product.Returns nothing
     * @param product, quantity
     */
    public void addProduct(Product product, int quantity){
        boolean duplicate = false;
        for(Product key: productQuant.keySet()){
            if(key.getId() == product.getId()){
                productQuant.replace(key,(productQuant.get(key)+quantity));
                duplicate=true;
            }
        }
        if(!duplicate){
            productQuant.put(product,quantity);
        }
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

}
