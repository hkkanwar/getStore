//Hussein El Mokdad 101171490

import java.util.HashMap;

public class ShoppingCart {
    private HashMap<Product, Integer> cart;

    /**
     *
     */
    public ShoppingCart(){cart = new HashMap<Product, Integer>();}

    /**
     *
     * @param product
     * @param quantity
     */
    public void addItem(Product product, int quantity){
        //Check if there is enough stock in inventory
        boolean isDuplicate = false;
        for(Product item: cart.keySet()){
            if(item.getId() == product.getId()){
                cart.replace(item, (cart.get(item)+quantity));
                isDuplicate=true;
            }
        }
        if(!isDuplicate){
            cart.put(product,quantity);
        }

        //Remove items from inventory
    }

    /**
     * 
     * @param product
     * @param quantity
     */
    public void removeItem(Product product, int quantity){
        for(Product item: cart.keySet()){
            if(item.getId() == product.getId()){
                cart.replace(item, (cart.get(item) - quantity));
                if (cart.get(item) < 0) cart.remove(item); //Should we remove it or set it to 0?
            }
        }
        //Add items back to inventory
    }

}
