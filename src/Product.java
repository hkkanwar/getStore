public class Product {
    private final String name;
    private final int id;
    private double price;

    public Product(String name, int id, double price){
        this.name = name;
        this.id = id;
        this.price = price;
    }

    public String getName() { return name; }

    public int getID() {
        return id;
    }

    public double getPrice() {
        return price;
    }
}
