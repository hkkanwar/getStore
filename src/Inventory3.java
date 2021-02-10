// Harsimran Kanwar 101143556
// Hussein Elmokdad idk ur number??

import java.util.ArrayList;


public class Inventory3 {
    private ArrayList<Product> productInventory;
    private ArrayList<Integer> productQuant;

    public Inventory3(){
        ArrayList<Product> productInventory = new ArrayList<Product>();
        ArrayList<Integer> productQuant = new ArrayList<Integer>();
    }


    /** Gets the quantity of stock of a given product
     * @param productId
     * @return stockNum (quantity of stock) */
    public int getStock(int productId){
        int stockNum = 0;
        for (int i= 0; i < productInventory.size(); i++){
            if(productInventory.get(i).getID() == productId){
                stockNum = productQuant.get(i);
            }
        }
        return stockNum;
    }

    /** Gets the stock of product given productId
     * @param productId
     * @return productInfo (product object of given id)*/
    public Product getProduct(int productId){
        Product productInfo = null;
        for (int i= 0; i < productInventory.size(); i++){
            if(productInventory.get(i).getID() == productId){
                productInfo = productInventory.get(i);
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
        for (int i= 0; i < productInventory.size(); i++){
            if(productInventory.get(i).getID() == product.getID()){
                productQuant.set(i,(productQuant.get(i)+quantity));
                duplicate=true;
            }
        }
        if(!duplicate){
            productInventory.add(product);
            productQuant.add(quantity);
        }
    }

    /** Removes product quantity given ProductID (@params)
     *  Removes 1 item from inventory (productQuant)
     *  If quantity is zero, nothing happens. Returns nothing.
     * */
    public void removeProduct(int productId) {
        for (int i = 0; i < productInventory.size(); i++) {
            if (productInventory.get(i).getID() == productId) {
                if (productQuant.get(i) != 0) {
                    productQuant.set(i,(productQuant.get(i) - 1));
                }
            }
        }
    }


}


