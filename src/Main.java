public class Main {
    public static void main(String[] args) {
        Product apple = new Product("Apple", 01, 0.5);
        Inventory2 inventory2 = new Inventory2();
        //Inventory inventory = new Inventory();
        //inventory.addProduct(apple, 10);
        //inventory.addProduct(apple, 10);
        //StoreManager manager = new StoreManager();
        //manager.inventory.addProduct(apple, 10);
        //System.out.println(manager.checkStock(apple));
        //System.out.println(inventory.getStock(01));
        inventory2.addProduct(apple, 10);
        System.out.println(inventory2.getStock(01));
    }
}
