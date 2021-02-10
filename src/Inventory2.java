//Harsimran Kanwar 101143556
// Hussein Elmokdad idk ur number??

import java.util.HashMap;

public class Inventory2 {

    private HashMap<Product, Integer> productQuant;
    // What do they mean by
    // "set  the  contents  of  the  Inventory  to  some  default  values  upon  object creation"?
    public Inventory2(){
        HashMap<Product, Integer> productQuant = new HashMap<Product, Integer>();
    }

    /** Gets the stock of product, given productId (@params)
     * and returns quantity of stock (@return)
     */
    public int getStock(int productId){
        int stockNum = 0;
        for(Product key: productQuant.keySet()){
            if(key.getId() == productId){
                stockNum = productQuant.get(key);
            }
        }
        return stockNum;
    }

    /** Gets the stock of product, given productId (@params)
     * and returns the product object with all details (@return)
     */
    public Product getProduct(int productId){
        Product productInfo = null;
        for(Product key: productQuant.keySet()){
            if(key.getId() == productId){
                productInfo = key;
            }
        }
        return productInfo;
    }

    /** Adds product, given product and quantity (@params)
     * Checks in case of duplicate, it will update quantity of said product
     * if new product, will add quantity to productQuant arrayList and add item
     * to productInventory arrayList. Returns nothing.
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

    /** Removes product quantity given ProductID (@params)
     *  Removes 1 item from inventory (productQuant)
     *  If quantity is zero, nothing happens. Returns nothing.
     * */
    public void removeProduct(int productId, int quantity) { //We need to update the docstring
        for(Product key: productQuant.keySet()){
            if(key.getId() == productId){
                productQuant.replace(key,(productQuant.get(key) - quantity));
                if (productQuant.get(key) < 0) productQuant.replace(key, 0);
            }
        }
    }

}
