package storetest;
/**
 * @author Harsimran Kanwar 101143556,
 * @author Hussein Elmokdad 101171490
 * @version 1.0
 */


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import myStore.Inventory;
import myStore.Product;

import javax.swing.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class InventoryTest {
    private static Inventory i1;
    private static Product p1;
    private static Product p2;
    private static Product p3;
    private static Product p4;
    private static Product p5;

    /**
     * Initializes the variables used throughout the test suite
     */
    @BeforeEach
    public void init() {
        // test fixture; executed before each test
        // creation of required objects, program state, etc.
        i1 = new Inventory();
        ImageIcon applesImage = new ImageIcon(new ImageIcon("src/myStore/Apples.jpg").getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));
        ImageIcon orangesImage = new ImageIcon(new ImageIcon("src/myStore/Oranges.jpg").getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));
        ImageIcon lemonsImage = new ImageIcon(new ImageIcon("src/myStore/Lemons.jpg").getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));
        p1 = new Product("Apple",01,0.5, applesImage);
        p2 = new Product("Lemon",03,0.8, lemonsImage);
        p3 = new Product("Kiwi",04,1.5, applesImage);
        p4 = new Product("Mango",05,1.2, applesImage);
        p5 = new Product("Pineapple",07,1.2, applesImage);

    }

    /**
     * Tests the getStock method for the quantity of products
     */
    @Test
    public void testGetStock() {
        //productId exists
        assertEquals(10,i1.getProductQuantity(p1),"bug in getStock method, returning wrong value");
        assertEquals(5,i1.getProductQuantity(p2),"bug in getStock method, returning wrong value");
        //this productId does not exist in inventory, should return 0 (corner case)
        assertEquals(0,i1.getProductQuantity(p3),"bug in getStock method, returning wrong value");
        assertEquals(0,i1.getProductQuantity(p4),"bug in getStock method, returning wrong value");
    }

    /**
     * Tests the getProduct method for the available product information
     */
   @Test
    public void testGetProduct() {
        //product exists
       assertEquals("Apple", i1.getProduct(01).getName(), "bug in getProduct method, returning wrong value");
       assertEquals(0.5, i1.getProduct(01).getPrice(), "bug in getProduct method, returning wrong value");
       assertEquals(01, i1.getProduct(01).getId(), "bug in getProduct method, returning wrong value");

       assertEquals("Orange", i1.getProduct(02).getName(), "bug in getProduct method, returning wrong value");
       assertEquals(1.2, i1.getProduct(02).getPrice(), "bug in getProduct method, returning wrong value");
       assertEquals(02, i1.getProduct(02).getId(), "bug in getProduct method, returning wrong value");

       //product doesn't exist, method will return null (corner case)
       assertNull(i1.getProduct(04),"bug in GetProduct method");
       assertNull(i1.getProduct(-1),"bug in GetProduct method");
   }

    /**
     * Tests the addProduct method to add product to our inventory
     */
    @Test
    public void testAddProduct() {
        i1.addProductQuantity(p1,4);
        i1.addProductQuantity(p2,7);
        //check that product quantity gets updated since product already exist (corner case)
        assertEquals(14,i1.getProductQuantity(p1),"bug in testAddProduct method,product not updated");
        assertEquals(12,i1.getProductQuantity(p2),"bug in testAddProduct method, product not updated");

        i1.addProductQuantity(p3,10);
        i1.addProductQuantity(p4, 25);
        //check product got added and exists in inventory
        assertTrue(i1.getProductQuant().containsKey(p3),"bug in testAddProduct method,product not added");
        assertTrue(i1.getProductQuant().containsKey(p4),"bug in testAddProduct method,product not added");
    }

    /**
     * Tests the removeProduct method to remove product quantities from our inventory
     */
    @Test
    public void testRemoveProduct() {
        i1.removeProductQuantity(p1,4);
        i1.removeProductQuantity(p2,1);
        //remove product quantity given product id
        assertEquals(6,i1.getProductQuantity(p1),"bug in testRemoveProduct method, product quantity not removed as expected");
        assertEquals(4,i1.getProductQuantity(p2),"bug in testRemoveProduct method, product quantity not removed as expected");

        //empty inventory for the product completely
        i1.removeProductQuantity(p3,10);
        i1.removeProductQuantity(p4,25);
        assertEquals(0,i1.getProductQuantity(p3),"bug in testRemoveProduct method, product quantity not removed as expected");
        assertEquals(0,i1.getProductQuantity(p4),"bug in testRemoveProduct method, product quantity not removed as expected");

        i1.removeProductQuantity(p4, 5);
        //check that product quantity is still 0 (corner case)
        assertEquals(0,i1.getProductQuantity(p4),"bug in testRemoveProduct method, product quantity not removed as expected");

        //check what happens with invalid productId (corner case)
        i1.removeProductQuantity(p5, 10);
        //ensure that this product never existed in inventory
        assertFalse(i1.getProductQuant().containsKey(p5),"product somehow exists in our inventory?");


    }


}
