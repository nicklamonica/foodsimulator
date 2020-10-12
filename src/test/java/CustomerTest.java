import junit.framework.*;

import customer.*;
import roll.RollFactory;
import store.RollStore;

import java.util.HashMap;

public class CustomerTest extends TestCase {
    RollStore rollStore;
    public CustomerTest() {
        this.rollStore = new RollStore(new RollFactory());
    }

    public void testCasualCustomer() {
        Customer customer = new CasualCustomer(rollStore);
        HashMap<String, Integer> order = customer.makeRollOrder();
        // make sure one roll type has been order
        assertEquals(1, order.size());
        // make sure number of the roll ordered is between 1 and 3
        for (String key: order.keySet()) {
            assert(1 <= order.get(key) && order.get(key) <= 3);
        }

    }

    public void testCateringCustomer() {
        Customer customer = new CateringCustomer(rollStore);
        HashMap<String, Integer> order = customer.makeRollOrder();
        // make sure one roll type has been order
        assertEquals(3, order.size());
        // make sure 5 rolls of each type where ordered
        for (String key: order.keySet()) {
            assert(5 ==  order.get(key));
        }
    }

    public void testBusinessCustomer() {
        Customer customer = new BusinessCustomer(rollStore);
        HashMap<String, Integer> order = customer.makeRollOrder();
        // make sure 5 roll types have been ordered
        assertEquals(5, order.size());
        // make sure 2 rolls of each type where ordered
        for (String key: order.keySet()) {
            assert(2 ==  order.get(key));
        }
    }
}
