public class Product {
    private final String NAME;
    private final int ID;
    private double price;

    public Product(String name, int ID, double price){
        this.NAME = name;
        this.ID = ID;
        this.price = price;
    }

    public String getName() { return NAME; }

    public int getID() {
        return ID;
    }

    public double getPrice() {
        return price;
    }
}
