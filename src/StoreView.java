//Hussein El Mokdad 101171490

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

    }

    public static void main(String[] args) {

    }
}
