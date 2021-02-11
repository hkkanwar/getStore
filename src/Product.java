// Harsimran Kanwar 101143556
// Hussein Elmokdad 101171490

public class Product {
    private final String name;
    private final int id;
    private final double price;

    public Product(String name, int id, double price){
        this.name = name;
        this.id = id;
        this.price = price;
    }

    /** Get the name of product
     * @return NAME
     */
    public String getName() { return name; }

    /** Get the id of product
     * @return ID
     */
    public int getId() { return id; }

    /** Get the price of product
     * @return PRICE
     */
    public double getPrice() { return price; }
}
