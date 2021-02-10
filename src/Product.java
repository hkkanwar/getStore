// Harsimran Kanwar 101143556
// Hussein Elmokdad 101171490

public class Product {
    private final String NAME;
    private final int ID;
    private final double PRICE;

    public Product(String name, int id, double price){
        this.NAME = name;
        this.ID = id;
        this.PRICE = price;
    }

    /** Get the name of product
     * @return NAME
     */
    public String getName() { return NAME; }

    /** Get the id of product
     * @return ID
     */
    public int getId() { return ID; }

    /** Get the price of product
     * @return PRICE
     */
    public double getPrice() { return PRICE; }
}
