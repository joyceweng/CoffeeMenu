package group3;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testing CoffeeOrderCollection class
 *
 * @author tammyle
 * @version 12/06/2020
 */
public class CoffeeOrderCollectionTest {

    //fields for testing
    CoffeeOrderCollection collection;
    CoffeeOrder o1;

    /**
     * Clears existing orders and sets up fields for testing.
     */
    public CoffeeOrderCollectionTest() {
    }

    @Before
    public void setUp() {
        //initialize collection
        collection = new CoffeeOrderCollection();
        //clear existing contacts
        CoffeeOrder[] orders = collection.getSortedArray();
        for (CoffeeOrder o : orders) {
            collection.deleteOrder(o);
        }
        //add one order
        o1 = new CoffeeOrder("Bob", true, "vanila", true);
        collection.addOrder(o1);
    }

    /**
     * Test of addOrder method, of class CoffeeOrderCollection.
     */
    @Test
    public void testAddOrder() {
        //test adding a new order
        assertTrue(collection.addOrder(new CoffeeOrder("Joseph", true, "vanilla", false)));
        //test adding an existing contact
        assertFalse(collection.addOrder(new CoffeeOrder("Bob", false, "french vanilla", false)));
        //test that the number of contacts is correct after adding
        int count = collection.getSortedArray().length;
        assertSame(count, 2);
        //test that the file contains the correct entries
        CoffeeOrderCollection collection2 = new CoffeeOrderCollection();
        CoffeeOrder[] orders = collection2.getSortedArray();
        assertSame(orders.length, 2);
        assertEquals(orders[0], o1);
    }

    /**
     * Test of deleteOrder method, of class CoffeeOrderCollection.
     */
    @Test
    public void testDeleteOrder() {
        //test that the collection has the correct number of orders
        int count = collection.getSortedArray().length;
        assertSame(count, 1);
        //delete the order and test the number again
        collection.deleteOrder(o1);
        count = collection.getSortedArray().length;
        assertSame(count, 0);
        //test that the file reflects the change
        CoffeeOrderCollection collection2 = new CoffeeOrderCollection();
        CoffeeOrder[] orders = collection2.getSortedArray();
        assertSame(orders.length, 0);
    }

    /**
     * Test of getSortedArray method, of class CoffeeOrderCollection.
     */
    @Test
    public void testGetSortedArray() {
        //test that added order is sorted correctly
        CoffeeOrder o2 = new CoffeeOrder("Joseph", true, "caramel", false);
        collection.addOrder(o2);
        CoffeeOrder[] orders = collection.getSortedArray();
        assertEquals(orders[0], o1);
    }

}
