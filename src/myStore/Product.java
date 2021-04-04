package myStore;
/**
 * @author Harsimran Kanwar 101143556,
 * @author Hussein Elmokdad 101171490
 * @version 1.0
 */

import javax.swing.*;
import java.util.Objects;

public class Product {
    private final String name;
    private final int id;
    private final double price;
    private final ImageIcon image;

    /**
     * Product Constructor
     * @param name the String name of the product
     * @param id the int id of the product
     * @param price the double price of the product
     * @param image an ImageIcon of the product image
     */
    public Product(String name, int id, double price, ImageIcon image){
        this.name = name;
        this.id = id;
        this.price = price;
        this.image = image;
    }

    /** Get the name of product
     * @return the String name
     */
    public String getName() { return name; }

    /** Get the id of product
     * @return the int id
     */
    public int getId() { return id; }

    /** Get the price of product
     * @return the double price
     */
    public double getPrice() { return price; }

    /**
     * Get the image of the product
     * @return the ImageIcon image
     */
    public ImageIcon getImageIcon(){
        return image;
    }
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
