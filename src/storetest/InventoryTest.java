package storetest;
/**
 * @author Harsimran Kanwar 101143556,
 * @author Hussein Elmokdad 101171490
 * @version 1.0
 */


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import StoreClass.Inventory;
import StoreClass.Product;

import static org.junit.jupiter.api.Assertions.*;

public class InventoryTest {
    private static Inventory i1;
    private static Product p1;
    private static Product p2;
    private static Product p3;
    private static Product p4;
    private static Product p5;

    @BeforeEach
    public void init() {
        // test fixture; executed before each test
        // creation of required objects, program state, etc.
        i1 = new Inventory();
        p1 = new Product("Apple",01,0.5);
        p2 = new Product("Lemon",03,0.8);
        p3 = new Product("Kiwi",04,1.5);
        p4 = new Product("Mango",05,1.2);
        p5 = new Product("Pineapple",07,1.2);

    }

    @Test
    public void testGetStock() {
        //productId exists
        assertEquals(10,i1.getStock(01),"bug in getStock method, returning wrong value");
        assertEquals(5,i1.getStock(02),"bug in getStock method, returning wrong value");
        //this productId does not exist in inventory, should return 0 (corner case)
        assertEquals(0,i1.getStock(04),"bug in getStock method, returning wrong value");
        assertEquals(0,i1.getStock(-45),"bug in getStock method, returning wrong value");
    }

   @Test
    public void testGetProduct() {
        //product exists
       assertEquals("Apple", i1.getProduct(01).getName(), "bug in getProduct method, returning wrong value");
       assertEquals("Orange", i1.getProduct(02).getName(), "bug in getProduct method, returning wrong value");
       //product doesn't exist, method will return null (corner case)
       assertNull(i1.getProduct(04));
       assertNull(i1.getProduct(-1));
   }

    @Test
    public void testAddProduct() {
        i1.addProduct(p1,4);
        i1.addProduct(p2,7);
        //check that product quantity gets updated since product already exist (corner case)
        assertEquals(14,i1.getStock(p1.getId()),"bug in testAddProduct method, returning wrong value");
        assertEquals(12,i1.getStock(p2.getId()),"bug in testAddProduct method, returning wrong value");

        i1.addProduct(p3,10);
        i1.addProduct(p4, 25);
        //check product got added and exists in inventory
        assertTrue(i1.getProductQuant().containsKey(p3));
        assertTrue(i1.getProductQuant().containsKey(p4));
    }


    @Test
    public void testRemoveProduct() {
        i1.removeProduct(p1.getId(),4);
        i1.removeProduct(p2.getId(),1);
        //remove product quantity given product id
        assertEquals(6,i1.getStock(p1.getId()),"bug in testRemoveProduct method, returning wrong value");
        assertEquals(4,i1.getStock(p2.getId()),"bug in testRemoveProduct method, returning wrong value");

        //empty inventory for the product completely
        i1.removeProduct(p3.getId(),10);
        i1.removeProduct(p4.getId(),25);
        assertEquals(0,i1.getStock(p3.getId()),"bug in testRemoveProduct method, returning wrong value");
        assertEquals(0,i1.getStock(p4.getId()),"bug in testRemoveProduct method, returning wrong value");

        i1.removeProduct(p4.getId(), 5);
        //check that product quantity is still 0 (corner case)
        assertEquals(0,i1.getStock(p4.getId()),"bug in testRemoveProduct method, returning wrong value");

        //check what happens with invalid productId (corner case)
        i1.removeProduct(p5.getId(), 10);
        //ensure that this product never existed in inventory
        assertFalse(i1.getProductQuant().containsKey(p5));


    }


}
