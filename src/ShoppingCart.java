//Hussein El Mokdad 101171490

import java.util.HashMap;

public class ShoppingCart {
    private HashMap<Product, Integer> cart;

    /**
     *
     */
    public ShoppingCart(){cart = new HashMap<Product, Integer>();}

    public HashMap<Product, Integer> getCart() {
        return cart;
    }



}
