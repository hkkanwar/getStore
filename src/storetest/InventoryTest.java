package storetest;
/**
 * @author Harsimran Kanwar 101143556,
 * @author Hussein Elmokdad 101171490
 * @version 1.0
 */


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import StoreClasses.Inventory;
import StoreClasses.Product;

import static org.junit.jupiter.api.Assertions.*;

public class InventoryTest {
    private static Inventory i1;
    private static Product p1;
    private static Product p2;
    private static Product p3;

    @BeforeEach
    public void init() {
        // test fixture; executed before each test
        // creation of required objects, program state, etc.
        i1 = new Inventory();
        p1 = new Product("Apple",01,0.5);
        //p2 = new Product("Lemon",03,0.8);
        //p3 = new Product("Kiwi",04,1.5);

    }

    @Test
    public void testgetStock() {
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
    public void testaddProduct() {
        /*
        assertEquals(10,s1.checkStock(p1),"bug in checkStock method, returning wrong value");
        assertEquals(5,s1.checkStock(p2),"bug in checkStock method, returning wrong value");
        //this product does not exist in inventory, should return 0 (corner case)
        assertEquals(0,s1.checkStock(p3),"bug in checkStock method, returning wrong value");

         */
    }

     /*
    @Test
    public void testaddProduct() {
        assertEquals(10,s1.checkStock(p1),"bug in checkStock method, returning wrong value");
        assertEquals(5,s1.checkStock(p2),"bug in checkStock method, returning wrong value");
        //this product does not exist in inventory, should return 0 (corner case)
        assertEquals(0,s1.checkStock(p3),"bug in checkStock method, returning wrong value");
    }
*/

}
