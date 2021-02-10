import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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
        Inventory2 inventory2 = new Inventory2();
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
        manager.inventory.addProduct(apple, 20);
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


    }
}
