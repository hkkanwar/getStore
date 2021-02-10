public class Main {
    public static void main(String[] args) {
        Product apple = new Product("Apple", 01, 0.5);
        Product orange = new Product("Orange", 02, 0.5);
        Product lemon = new Product("Lemon", 03, 0.5);
        Inventory inventory2 = new Inventory();
        //Inventory inv3 = new Inventory();
        //Inventory inventory = new Inventory();
        //inventory.addProduct(apple, 10);
        //inventory.addProduct(apple, 10);
        //StoreManager manager = new StoreManager();
        //manager.inventory.addProduct(apple, 10);
        //System.out.println(manager.checkStock(apple));
        //System.out.println(inventory.getStock(01));
        inventory2.addProduct(apple, 10);
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
    }
}
