package storetest;
/**
 * @author Harsimran Kanwar 101143556,
 * @author Hussein Elmokdad 101171490
 * @version 1.0
 */
import StoreClasses.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import StoreClasses.StoreManager;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class StoreManagerTest {
    private static StoreManager s1;
    private static Product p1;
    private static Product p2;
    private static Product p3;
    private static HashMap<Product, Integer> cart1;
    private static HashMap<Product, Integer> cart2;
    /**
     *
     */
    @BeforeEach
    public void init() {
        // test fixture; executed before each test
        // creation of required objects, program state, etc.
        s1 = new StoreManager();
        p1 = new Product("Apple",01,0.5);
        p2 = new Product("Lemon",03,0.8);
        p3 = new Product("Kiwi",04,1.5);
        cart1 = new HashMap<Product, Integer>();
        cart2 = new HashMap<Product, Integer>();
        cart1.put(p1, 10);
        cart1.put(p3, 10);
    }

    /**
     *
     */
    @Test
    public void testCheckStock() {
        assertEquals(10,s1.checkStock(p1),"bug in checkStock method, returning wrong value");
        assertEquals(5,s1.checkStock(p2),"bug in checkStock method, returning wrong value");
        //this product does not exist in inventory, should return 0 (corner case)
        assertEquals(0,s1.checkStock(p3),"bug in checkStock method, returning wrong value");
    }

    /**
     * 
     */
    @Test
    public void testProcessTransaction() {
        assertEquals(20.0,s1.processTransaction(cart1, 0),"bug in ProcessTransaction method, incorrect returned sum");
        assertEquals(0.0,s1.processTransaction(cart2, 0),"bug in ProcessTransaction method, incorrect returned sum");
    }

    @Test
    public void testAddItemToCart() {

    }

    @Test
    public void testRemoveItemFromCart() {

    }

    @Test
    public void testGetCart() {

    }

    @Test
    public void testAssignNewCartID() {

    }

    @Test
    public void testShowInventory() {

    }

    @Test
    public void testShowCart() {

    }

    @Test
    public void testReturnItemsToInventory() {

    }
}
