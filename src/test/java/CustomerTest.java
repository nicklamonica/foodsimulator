import junit.framework.*;
import static org.junit.Assert.*;

import customer.*;
import org.hamcrest.CoreMatchers;
import roll.types.SausageRoll;
import store.RollStore;

import java.util.HashMap;
import roll.*;

public class CustomerTest extends TestCase {
    RollStore rollStore;
    public CustomerTest() {
        this.rollStore = new RollStore();
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

    public void testRandomDecorations() {
        Roll roll = new SausageRoll();
        RollFactory factory = new RollFactory();

        Roll roll1 = factory.createRoll("sausage");
        Roll roll2 = factory.createRoll("jelly");
        Roll roll3 = factory.createRoll("egg");
        Roll roll4 = factory.createRoll("spring");
        Roll roll5 = factory.createRoll("pastry");

        String r1 = roll1.getDescription();
        String r2 = roll2.getDescription();
        String r3 = roll3.getDescription();
        String r4 = roll4.getDescription();
        String r5 = roll5.getDescription();
        
        assertEquals(r1.contains("Sauces") || r1.contains("Toppings") || r1.contains("Filling"), true);
        assertEquals(r2.contains("Sauces") || r2.contains("Toppings") || r2.contains("Filling"), true);
        assertEquals(r3.contains("Sauces") || r3.contains("Toppings") || r3.contains("Filling"), true);
        assertEquals(r4.contains("Sauces") || r4.contains("Toppings") || r4.contains("Filling"), true);
        assertEquals(r5.contains("Sauces") || r5.contains("Toppings") || r5.contains("Filling"), true);

        //Check that the correct string is printed for each type
        assertThat(r1, CoreMatchers.containsString("Sausage Roll"));
        assertThat(r2, CoreMatchers.containsString("Jelly Roll"));
        assertThat(r3, CoreMatchers.containsString("Egg Roll"));
        assertThat(r4, CoreMatchers.containsString("Spring Roll"));
        assertThat(r5, CoreMatchers.containsString("Pastry Roll"));
    }

    public void testRollCosts() {
        Roll roll = new SausageRoll();
        RollFactory factory = new RollFactory();

        Roll roll1 = factory.createRoll("sausage");
        Roll roll2 = factory.createRoll("jelly");
        Roll roll3 = factory.createRoll("egg");
        Roll roll4 = factory.createRoll("spring");
        Roll roll5 = factory.createRoll("pastry");

        Double r1 = roll1.cost();
        Double r2 = roll2.cost();
        Double r3 = roll3.cost();
        Double r4 = roll4.cost();
        Double r5 = roll5.cost();

        assertEquals(r1 > 0.0, true);
        assertEquals(r2 > 0.0, true);
        assertEquals(r3 > 0.0, true);
        assertEquals(r4 > 0.0, true);
        assertEquals(r5 > 0.0, true);

    }

    public void testRollAmounts() {
        rollStore.rollStoreInventory.
    }
}
