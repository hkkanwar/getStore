public class Product {
    private final String NAME;
    private final int ID;
    private final double price;

    public Product(String name, int id, double price){
        this.NAME = name;
        this.ID = id;
        this.price = price;
    }

    public String getName() { return NAME; }

    public int getId() {
        return ID;
    }

    public double getPrice() {
        return price;
    }
}
