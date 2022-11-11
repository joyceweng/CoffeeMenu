package group3;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testing CoffeeOrder class
 *
 * @author Phuoc Nguyen
 * @version 12/06/2020
 */
public class CoffeeOrderTest {

    //fields for testing
    CoffeeOrder o1, o2, o3, o4;

    @Before
    public void setUp() {
        o1 = new CoffeeOrder("Tammy", false, "vanilla", false);
        o2 = new CoffeeOrder("Tammy", false, "french vanilla", true);
        o3 = new CoffeeOrder("Joyce", true, "mocha", false);
        o4 = new CoffeeOrder("Phuoc", true, "caramel", true);
    }

    /**
     * Test of compareTo method, of class CoffeeOrder.
     */
    @Test
    public void testCompareTo() {
        assertSame(o1.compareTo(o2), 0);
    }

}
