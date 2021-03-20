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
import java.util.Arrays;
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
        cart1.put(p2, 10);
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
        assertEquals(13.0,s1.processTransaction(cart1, 0),"bug in ProcessTransaction method, incorrect returned sum");
        assertEquals(0.0,s1.processTransaction(cart2, 0),"bug in ProcessTransaction method, incorrect returned sum");
    }

    @Test
    public void testAddItemToCart() {
        s1.assignNewCartID();
        s1.assignNewCartID();
        s1.addItemToCart(p1, 3, 0);
        s1.addItemToCart(p2, 2, 0);
        assertTrue(s1.getCart(0).containsKey(p1), "cart is missing an item");
        assertTrue(s1.getCart(0).containsKey(p2), "cart is missing an item");
        assertFalse(s1.getCart(0).containsKey(p3), "cart contains an extra item");
        assertFalse(s1.getCart(1).containsKey(p1), "cart should be empty");
        assertFalse(s1.getCart(1).containsKey(p2), "cart should be empty");
        assertFalse(s1.getCart(1).containsKey(p3), "cart should be empty");
        assertEquals(3, s1.getCart(0).get(p1), "quantity of an item is wrong");
        assertEquals(2, s1.getCart(0).get(p2), "quantity of an item is wrong");
    }

    @Test
    public void testRemoveItemFromCart() {
        s1.assignNewCartID();
        s1.addItemToCart(p1, 3, 0);
        s1.addItemToCart(p2, 2, 0);
        s1.removeItemFromCart(p2, 1, 0);
        assertTrue(s1.getCart(0).containsKey(p2), "cart is missing an item");
        assertEquals(1, s1.getCart(0).get(p2), "quantity of an item is wrong");
        s1.removeItemFromCart(p2, 1, 0);
        assertFalse(s1.getCart(0).containsKey(p2), "cart should not have the item");
        s1.removeItemFromCart(p1, 3, 0);
        assertFalse(s1.getCart(0).containsKey(p1), "cart should not have the item");
    }

    @Test
    public void testGetCart() {
        s1.assignNewCartID();
        s1.assignNewCartID();
        s1.addItemToCart(p1, 10, 0);
        s1.addItemToCart(p2, 5, 0);
        assertTrue(s1.getCart(0).containsKey(p1), "cart is missing an item");
        assertTrue(s1.getCart(0).containsKey(p2), "cart is missing an item");
        assertFalse(s1.getCart(0).containsKey(p3), "cart contains an extra item");
        assertEquals(10, s1.getCart(0).get(p1), "quantity of an item is wrong");
        assertEquals(5, s1.getCart(0).get(p2), "quantity of an item is wrong");
    }

    @Test
    public void testAssignNewCartID() {
        assertEquals(0, s1.assignNewCartID(), "Wrong ID");
        assertEquals(1, s1.assignNewCartID(), "Wrong ID");
        assertEquals(2, s1.assignNewCartID(), "Wrong ID");
    }

    @Test
    public void testShowInventory() {
        s1.showInventory();
    }

    @Test
    public void testShowCart() {

    }

    @Test
    public void testReturnItemsToInventory() {

    }
}
