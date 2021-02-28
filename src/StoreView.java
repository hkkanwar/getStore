// Harsimran Kanwar 101143556
// Hussein Elmokdad 101171490

import java.util.Scanner;

public class StoreView {

    public StoreManager storeManager; //Change back to private
    private int cartID;

    /**
     *
     * @param storeManager
     * @param cartID
     */
    public StoreView(StoreManager storeManager, int cartID){
        this.storeManager = storeManager;
        this.cartID = cartID;
    }

    /**
     *
     * @return
     */
    public int getCartID() {
        return cartID;
    }

    /**
     *
     */
    public void displayGUI(){


        System.out.println("Pick an item:");
        storeManager.showInventory();
        System.out.print(">>> ");
        Scanner option = new Scanner(System.in);
        int pickedOption = option.nextInt();

        System.out.print("Enter quantity: ");
        Scanner quantity = new Scanner(System.in);
        int quantityNum = quantity.nextInt();
    }
    /*
    public static void main(String[] args) {

        REMEMBER THAT THIS IS A STATIC METHOD!!!

        System.out.println("Choose your StoreView: ");
        Scanner storeView = new Scanner(System.in);
        int storeViewNum = storeView.nextInt();
        Product apple = new Product("Apple", 01, 0.5);
        StoreManager sm = new StoreManager();
        StoreView view0 = new StoreView(sm, sm.assignNewCartID());
        StoreView view1 = new StoreView(sm, sm.assignNewCartID());

        //view0.displayGUI();
        //view0.storeManager.addItemToCart(apple, 2, view0.getCartID());
        //view0.storeManager.removeItemFromCart(apple, 5, view0.getCartID());

        //view1.storeManager.addItemToCart(apple, 5, view1.getCartID());
        //view1.storeManager.removeItemFromCart(apple, 1, view1.getCartID());

        //System.out.println(sm.checkStock(apple));
        //System.out.println(sm.shoppingCartArray.size());
        //System.out.println(sm.shoppingCartArray.get(0).getCart().keySet());
        //System.out.println(sm.shoppingCartArray.get(1).getCart().keySet());
    }
     */
}
