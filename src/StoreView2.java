package myStore; /**
 * @author Harsimran Kanwar 101143556,
 * @author Hussein Elmokdad 101171490
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StoreView2 {

    private StoreManager storeManager;
    private int cartID;

    /**
     * Constructor for StoreView
     * @param storeManager    StoreManager object
     * @param cartID          int value for the Id of the cart
     */
    public StoreView2(StoreManager storeManager, int cartID){
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
     * Method to display the user interface. Allows the user to interact
     * with the store
     * @return true when the user quits or checkouts
     */
    public boolean displayGUI(){
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
                // Contains nested try catch blocks
                System.out.println("|--------------- The getSTore store ---------------|");
                System.out.println("\\--------------------- add -----------------------/");
                System.out.println("Pick an item to add (number to the left of the product):");
                ArrayList<Product> products = storeManager.showInventory();
                System.out.print(">>> ");
                try{
                    Scanner option = new Scanner(System.in);
                    int pickedOption = option.nextInt();
                    System.out.print("Enter quantity: ");
                    Scanner quantity = new Scanner(System.in);
                    int quantityNum = quantity.nextInt();
                    storeManager.addItemToCart(products.get(pickedOption), quantityNum, cartID);
                    System.out.println("---------------------------------------------------");
                }
                catch(IndexOutOfBoundsException e){
                    System.out.println("Item was not added to cart (Invalid option entered)");
                    System.out.println("Please try again");
                    try{
                        System.out.print(">>> ");
                        Scanner option = new Scanner(System.in);
                        int pickedOption = option.nextInt();
                        System.out.print("Enter quantity: ");
                        Scanner quantity = new Scanner(System.in);
                        int quantityNum = quantity.nextInt();
                        storeManager.addItemToCart(products.get(pickedOption), quantityNum, cartID);
                        System.out.println("---------------------------------------------------");
                    }
                    catch(IndexOutOfBoundsException e2){
                        System.out.println("Failed to process request (Invalid option entered)");
                    }
                    catch(InputMismatchException e2){
                        // When the user enter a non integer
                        System.out.println("Failed to process request (Must enter an integer)");
                    }
                }
                catch(InputMismatchException e){
                    System.out.println("Item was not added to cart (Must enter an integer)");
                    System.out.println("Please try again");
                    try{
                        System.out.print(">>> ");
                        Scanner option = new Scanner(System.in);
                        int pickedOption = option.nextInt();
                        System.out.print("Enter quantity: ");
                        Scanner quantity = new Scanner(System.in);
                        int quantityNum = quantity.nextInt();
                        storeManager.addItemToCart(products.get(pickedOption), quantityNum, cartID);
                        System.out.println("---------------------------------------------------");
                    }
                    catch(IndexOutOfBoundsException e2){
                        System.out.println("Failed to process request (Invalid option entered)");
                    }
                    catch(InputMismatchException e2){
                        // When the user enter a non integer
                        System.out.println("Failed to process request (Must enter an integer)");
                    }
                }
            }
            else if (cmdPicked.equals("removefromcart")){
                // Contains nested try catch blocks
                System.out.println("|--------------- The getSTore store ---------------|");
                System.out.println("\\----------------- removefromcart ----------------/");
                System.out.println("Pick an item to remove (number to the left of the product):");
                ArrayList<Product> products = storeManager.showCart(cartID);
                System.out.print(">>> ");
                try{
                    Scanner option = new Scanner(System.in);
                    int pickedOption = option.nextInt();
                    System.out.print("Enter quantity: ");
                    Scanner quantity = new Scanner(System.in);
                    int quantityNum = quantity.nextInt();
                    storeManager.removeItemFromCart(products.get(pickedOption), quantityNum, cartID);
                }
                catch(IndexOutOfBoundsException e){
                    System.out.println("Item was not removed from cart (Invalid option entered)");
                    System.out.println("Please try again");
                    try{
                        System.out.print(">>> ");
                        Scanner option = new Scanner(System.in);
                        int pickedOption = option.nextInt();
                        System.out.print("Enter quantity: ");
                        Scanner quantity = new Scanner(System.in);
                        int quantityNum = quantity.nextInt();
                        storeManager.removeItemFromCart(products.get(pickedOption), quantityNum, cartID);
                    }
                    catch(IndexOutOfBoundsException e2){
                        System.out.println("Failed to process request (Invalid option entered)");
                    }
                    catch(InputMismatchException e2){
                        System.out.println("Failed to process request (Must enter an integer)");
                    }
                }
                catch(InputMismatchException e){
                    System.out.println("Item was not removed from cart (Must enter an integer)");
                    System.out.println("Please try again");
                    try{
                        System.out.print(">>> ");
                        Scanner option = new Scanner(System.in);
                        int pickedOption = option.nextInt();
                        System.out.print("Enter quantity: ");
                        Scanner quantity = new Scanner(System.in);
                        int quantityNum = quantity.nextInt();
                        storeManager.removeItemFromCart(products.get(pickedOption), quantityNum, cartID);
                    }
                    catch(IndexOutOfBoundsException e2){
                        System.out.println("Failed to process request (Invalid option entered)");
                    }
                    catch(InputMismatchException e2){
                        System.out.println("Failed to process request (Must enter an integer)");
                    }
                }
                System.out.println("---------------------------------------------------");

            }
            else if (cmdPicked.equals("showcart")){
                System.out.println("|--------------- The getSTore store ---------------|");
                System.out.println("\\------------ showing items in cart --------------/");
                storeManager.showCart(cartID);
                System.out.println("---------------------------------------------------");
            }
            else if (cmdPicked.equals("checkout")){
                storeManager.processTransaction(storeManager.getCart(cartID), cartID);
                return true;
            }
            else System.out.println("Please enter a valid command");
            System.out.println("Enter a command");
            System.out.println("Type \"Help\" for a list of commands");
            System.out.println("Type \"Quit\" when you are done");
            System.out.print(">>> ");
            cmdPicked = cmd.nextLine();
        }
        storeManager.returnItemsToInventory(cartID); //When the user quits
        return true;
    }

    public static void main(String[] args) {
        StoreManager sm = new StoreManager();
        StoreView2 sv1 = new StoreView2(sm, sm.assignNewCartID());
        StoreView2 sv2 = new StoreView2(sm, sm.assignNewCartID());
        StoreView2 sv3 = new StoreView2(sm, sm.assignNewCartID());
        StoreView2[] users = {sv1, sv2, sv3};
        int activeSV = users.length;
        Scanner sc = new Scanner(System.in);
        while (activeSV > 0) {
            System.out.print("CHOOSE YOUR STOREVIEW >>> ");
            //int choice = sc.nextInt();
            int choice;
            while(true) {
                try {
                    choice = sc.nextInt();
                    break;
                }
                catch(InputMismatchException ex ) {
                    System.out.print("Input was not a valid StoreView, please enter a valid StoreView integer >>>");
                    sc.next();
                    continue;
                }
            }

            if (choice < users.length && choice >= 0) {
                if (users[choice] != null) {
                    String chooseAnother = "";
                    while (!chooseAnother.equals("y") && !chooseAnother.equals("Y")) {
                        // this implementation of displayGUI waits for input and displays the page
                        // corresponding to the user's input. it does this once, and then returns
                        // true if the user entered 'checkout' or 'quit'.
                        if (users[choice].displayGUI()) {
                            users[choice] = null;
                            activeSV--;
                            break;
                        }
                        System.out.print("GO TO ANOTHER STOREVIEW? (y) >>> ");
                        chooseAnother = sc.next();
                    }
                }
                else System.out.println("MAIN > ERROR > BAD CHOICE\nTHAT STOREVIEW WAS DEACTIVATED");
            } else System.out.println(String.format("MAIN > ERROR > BAD CHOICE\nPLEASE CHOOSE IN RANGE [%d, %d]", 0, users.length - 1));
        }
        System.out.println("ALL STOREVIEWS DEACTIVATED");
    }
}
