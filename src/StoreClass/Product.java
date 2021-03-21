package StoreClass;
/**
 * @author Harsimran Kanwar 101143556,
 * @author Hussein Elmokdad 101171490
 * @version 1.0
 */

import java.util.Objects;

public class Product {
    private final String name;
    private final int id;
    private final double price;

    /**
     * Product Constructor
     * @param name
     * @param id
     * @param price
     */
    public Product(String name, int id, double price){
        this.name = name;
        this.id = id;
        this.price = price;
    }

    /** Get the name of product
     * @return name
     */
    public String getName() { return name; }

    /** Get the id of product
     * @return id
     */
    public int getId() { return id; }

    /** Get the price of product
     * @return price
     */
    public double getPrice() { return price; }

    /**
     * Compares two Product objects and checks if they're equal
     * @param o the Object to compare with
     * @return true if they have the same id, price, and name. false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && Double.compare(product.price, price) == 0 && name.equals(product.name);
    }

    /**
     * generates a code depending on the product's name, id, and price
     * @return an int number that represents the hashCode of the product
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, id, price);
    }
}
