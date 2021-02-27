import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /*
        HashMap<Product, Integer> shoppingList = new HashMap<Product, Integer>();
        System.out.println("Testing Inventory");
        System.out.println("Enter product name:");
        Scanner name = new Scanner(System.in);
        name.nextLine();
        System.out.println("Enter product ID:");
        Scanner ID = new Scanner(System.in);
        ID.nextInt();
        Product apple = new Product("Apple", 01, 0.5);
        shoppingList.put(apple, 5);
        Inventory inventory2 = new Inventory();
        Product orange = new Product("Orange", 02, 0.5);
        Product lemon = new Product("Lemon", 03, 0.5);
        //Inventory inventory2 = new Inventory();
        //Inventory inv3 = new Inventory();
        //Inventory inventory = new Inventory();
        //inventory.addProduct(apple, 10);
        //inventory.addProduct(apple, 10);
        StoreManager manager = new StoreManager();
        System.out.println(manager.checkStock(apple) + "----");
        //manager.inventory.addProduct(apple, 10);
        //System.out.println(manager.checkStock(apple));
        //System.out.println(inventory.getStock(01));
        inventory2.addProduct(apple, 10);
        inventory2.removeProduct(01, 2);
        System.out.println(inventory2.getStock(01));
        System.out.println(inventory2.getProduct(01).getName());
        //manager.inventory.addProduct(apple, 20);
        System.out.println(manager.checkStock(apple) + "----");
        manager.processTransaction(shoppingList);
        System.out.println(manager.checkStock(apple) + "----");
        manager.processTransaction(shoppingList);
        System.out.println(manager.checkStock(apple) + "----");
        manager.processTransaction(shoppingList);
        System.out.println(manager.checkStock(apple) + "----");
        manager.processTransaction(shoppingList);
        System.out.println(manager.checkStock(apple) + "----");
        manager.processTransaction(shoppingList);
        System.out.println(manager.checkStock(apple) + "----");
        manager.processTransaction(shoppingList);
        System.out.println(manager.checkStock(apple) + "----");
        manager.processTransaction(shoppingList);
        System.out.println(manager.checkStock(apple) + "----");
        System.out.println(manager.processTransaction(shoppingList) + "----");

        inventory2.addProduct(orange, 10);
        inventory2.addProduct(lemon, 10);
        inventory2.addProduct(orange, 10);
        //System.out.println(inventory2.getStock(01));
        System.out.println(inventory2.getProduct(03).getName());
        inventory2.removeProduct(03,10);
        System.out.println(inventory2.getStock(03));
        inventory2.removeProduct(03,10);
        System.out.println(inventory2.getStock(03));
        //System.out.println(inv3.getProduct(00).getName());
         */

        Product apple = new Product("Apple", 01, 0.5);
        Product apple1 = new Product("Apple", 01, 0.5);
        StoreManager sm = new StoreManager();
        StoreView view0 = new StoreView(sm, sm.assignNewCartID());
        StoreView view1 = new StoreView(sm, sm.assignNewCartID());

        //view0.displayGUI();
        /*view0.storeManager.addItemToCart(apple, 2, view0.getCartID());
        view0.storeManager.removeItemFromCart(apple, 5, view0.getCartID());

        view1.storeManager.addItemToCart(apple, 5, view1.getCartID());
        view1.storeManager.removeItemFromCart(apple, 1, view1.getCartID());

        System.out.println(sm.checkStock(apple));
        System.out.println(sm.shoppingCartArray.size());
        System.out.println(sm.shoppingCartArray.get(0).getCart().keySet());
        System.out.println(sm.shoppingCartArray.get(1).getCart().keySet());

         */
        sm.inventory.addProduct(apple, 10);
        sm.inventory.addProduct(apple, 2);
        sm.inventory.addProduct(apple1, 3);
    }

}
