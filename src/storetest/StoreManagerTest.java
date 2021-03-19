package storetest;

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

    @BeforeEach
    public void init() {
        // test fixture; executed before each test
        // creation of required objects, program state, etc.
        s1 = new StoreManager();
        p1 = new Product("Apple",01,0.5);
        p2 = new Product("Lemon",03,0.8);
        p3 = new Product("Kiwi",04,1.5);


    }

    @Test
    public void testCheckStock() {
        assertEquals(10,s1.checkStock(p1),"bug in checkStock method, returning wrong value");
        assertEquals(5,s1.checkStock(p2),"bug in checkStock method, returning wrong value");
        //this product does not exist in inventory, should return 0 (corner case)
        assertEquals(0,s1.checkStock(p3),"bug in checkStock method, returning wrong value");
    }

    @Test
    public void testProcessTransaction() {

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
