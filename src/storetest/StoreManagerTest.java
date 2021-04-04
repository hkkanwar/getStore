package storetest;
/**
 * @author Harsimran Kanwar 101143556,
 * @author Hussein Elmokdad 101171490
 * @version 1.0
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.awt.*;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
import myStore.StoreManager;
import myStore.Product;

import javax.swing.*;


public class StoreManagerTest {
    private static StoreManager s1;
    private static Product p1;
    private static Product p2;
    private static Product p3;
    private static Product p4;
    private static HashMap<Product, Integer> cart1;
    private static HashMap<Product, Integer> cart2;

    /**
     * Initializes the variables used throughout the test suite
     */
    @BeforeEach
    public void init() {
        // test fixture; executed before each test
        // creation of required objects, program state, etc.
        s1 = new StoreManager();
        ImageIcon applesImage = new ImageIcon(new ImageIcon("src/StoreClass/Apples.jpg").getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));
        ImageIcon orangesImage = new ImageIcon(new ImageIcon("src/StoreClass/Oranges.jpg").getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));
        ImageIcon lemonsImage = new ImageIcon(new ImageIcon("src/StoreClass/Lemons.jpg").getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));
        p1 = new Product("Apple",01,0.5, applesImage);
        p2 = new Product("Lemon",03,0.8, lemonsImage);
        p3 = new Product("Orange",02,1.2, orangesImage);
        p4 = new Product("Kiwi",04,1.5, applesImage);
        cart1 = new HashMap<Product, Integer>();
        cart2 = new HashMap<Product, Integer>();
        cart1.put(p1, 10);
        cart1.put(p2, 3);
    }

    /**
     * Tests the checkStock method for the quantity of products
     */
    @Test
    public void testCheckStock() {
        assertEquals(10,s1.checkStock(p1),"bug in checkStock method, returning wrong value");
        assertEquals(5,s1.checkStock(p2),"bug in checkStock method, returning wrong value");
        //this product does not exist in inventory, should return 0 (corner case)
        assertEquals(0,s1.checkStock(p4),"bug in checkStock method, returning wrong value");
    }

    /**
     * Tests processTransaction to see if it returns the correct total
     */
    @Test
    public void testProcessTransaction() {
        assertEquals(7.4,s1.processTransaction(cart1, 0),"bug in ProcessTransaction method, incorrect returned sum");
        assertEquals(0.0,s1.processTransaction(cart2, 0),"bug in ProcessTransaction method, incorrect returned sum");
    }

    /**
     * Tests if addItemsToCart successfully adds items to a user's cart
     */
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

    /**
     * Tests if removeItemsFromCart successfully removes items from a user's cart
     */
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

    /**
     * Tests if getCart returns the right cart
     */
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

    /**
     * Tests if assignNewCartID updates the cart counter
     */
    @Test
    public void testAssignNewCartID() {
        assertEquals(0, s1.assignNewCartID(), "Wrong ID");
        assertEquals(1, s1.assignNewCartID(), "Wrong ID");
        assertEquals(2, s1.assignNewCartID(), "Wrong ID");
    }

    /**
     * Tests if showInventory returns the right ArrayList
     */
    @Test
    public void testShowInventory() {
        s1.assignNewCartID();
        assertTrue(s1.showInventory().contains(p1), "Inventory is missing an item");
        assertTrue(s1.showInventory().contains(p2), "Inventory is missing an item");
        assertTrue(s1.showInventory().contains(p3), "Inventory is missing an item");
    }

    /**
     * Tests if showCart returns the right ArrayList
     */
    @Test
    public void testShowCart() {
        s1.assignNewCartID();
        s1.addItemToCart(p1, 1, 0);
        assertTrue(s1.showCart(0).contains(p1), "Cart is missing an item");
        assertFalse(s1.showCart(0).contains(p2), "Cart has an extra item");
        s1.addItemToCart(p2, 1, 0);
        assertTrue(s1.showCart(0).contains(p2), "Cart is missing an item");
    }

    /**
     * Tests if returnItemsToInventory updates the inventory
     */
    @Test
    public void testReturnItemsToInventory() {
        s1.assignNewCartID();
        s1.addItemToCart(p1, 5, 0);
        assertEquals(5, s1.checkStock(p1), "Inventory was not updated");
        s1.returnItemsToInventory(0);
        assertEquals(10, s1.checkStock(p1), "Items were not added back to inventory");
    }
}
