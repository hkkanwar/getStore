//Hussein El Mokdad 101171490

public class StoreView {

    private StoreManager storeManager;
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

    }
}
