/**
 * @author Harsimran Kanwar 101143556,
 * @author Hussein Elmokdad 101171490
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.Scanner;

public class StoreView {

    private StoreManager storeManager;
    private int cartID;

    /**
     * Constructor for StoreView
     * @param storeManager    StoreManager object
     * @param cartID          int value for the Id of the cart
     */
    public StoreView(StoreManager storeManager, int cartID){
        this.storeManager = storeManager;
        this.cartID = cartID;
    }

    /**
     * Fetches id of the cart
     * @return cartID   int value of id of cart
     */
    public int getCartID() {
        return cartID;
    }

    /**
     * Method to display the user interface
     */
    public void displayGUI(){
        System.out.println("Enter a command");
        System.out.println("Type \"Help\" for a list of commands");
        System.out.println("Type Quit when you are done");
        System.out.print(">>> ");
        Scanner cmd = new Scanner(System.in);
        String cmdPicked = cmd.nextLine();
        while(!cmdPicked.equals("quit") && !cmdPicked.equals("Quit")){
            if(cmdPicked.equals("Help") || cmdPicked.equals("help")){
                System.out.println("|--------------- The getSTore store ---------------|");
                System.out.println("\\------------------- commands --------------------/");
                System.out.println("browse");
                System.out.println("addtocart");
                System.out.println("removefromcart");
                System.out.println("showcart");
                System.out.println("checkout");
                System.out.println("---------------------------------------------------");
            }
            else if (cmdPicked.equals("browse")){
                System.out.println("|--------------- The getSTore store ---------------|");
                System.out.println("\\--------------------- browse -----------------------/");
                ArrayList<Product> products = storeManager.showInventory();
                System.out.println("---------------------------------------------------");
            }
            else if (cmdPicked.equals("addtocart")){
                System.out.println("|--------------- The getSTore store ---------------|");
                System.out.println("\\--------------------- add -----------------------/");
                System.out.println("Pick an item to add:");
                ArrayList<Product> products = storeManager.showInventory();
                System.out.print(">>> ");
                Scanner option = new Scanner(System.in);
                int pickedOption = option.nextInt();
                System.out.print("Enter quantity: ");
                Scanner quantity = new Scanner(System.in);
                int quantityNum = quantity.nextInt();
                storeManager.addItemToCart(products.get(pickedOption), quantityNum, cartID);
                System.out.println("---------------------------------------------------");
            }
            else if (cmdPicked.equals("removefromcart")){
                System.out.println("|--------------- The getSTore store ---------------|");
                System.out.println("\\----------------- removefromcart ----------------/");
                System.out.println("Pick an item to remove:");
                ArrayList<Product> products = storeManager.showCart(cartID);
                System.out.print(">>> ");
                Scanner option = new Scanner(System.in);
                int pickedOption = option.nextInt();
                System.out.print("Enter quantity: ");
                Scanner quantity = new Scanner(System.in);
                int quantityNum = quantity.nextInt();
                storeManager.removeItemFromCart(products.get(pickedOption), quantityNum, cartID);
                System.out.println("---------------------------------------------------");

            }
            else if (cmdPicked.equals("showcart")){
                System.out.println("|--------------- The getSTore store ---------------|");
                System.out.println("\\------------ showing items in cart --------------/");
                storeManager.showCart(cartID);
                System.out.println("---------------------------------------------------");
            }
            else if (cmdPicked.equals("checkout")){
                storeManager.processTransaction(storeManager.getCart(cartID));
                break;
            }
            else System.out.println("Please enter a valid command");
            System.out.println("Enter a command");
            System.out.println("Type \"Help\" for a list of commands");
            System.out.println("Type \"Quit\" when you are done");
            System.out.print(">>> ");
            cmdPicked = cmd.nextLine();
        }

    }

    public static void main(String[] args) {
        StoreManager sm = new StoreManager();
        StoreView view0 = new StoreView(sm, sm.assignNewCartID());
        view0.displayGUI();
    }

}
