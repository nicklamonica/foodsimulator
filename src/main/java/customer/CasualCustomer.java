package customer;

import store.RollStore;
import java.util.HashMap;

public class CasualCustomer extends Customer {

    public CasualCustomer(RollStore rollStore) {
        super(rollStore);
    }

    // buys 1 to 3 rolls
    public HashMap<String, Integer> makeRollOrder() {
        HashMap<String,Integer> order = new HashMap<>();
        int numToOrder = rand.nextInt(3) + 1;
        String rollToOrder = this.getRandomRollTypes(1).get(0);
        order.put(rollToOrder, numToOrder);
        return order;
    }

    // casual customer just takes whatever is left of their roll order
    public HashMap<String, Integer> makeModifiedRollOrder(HashMap<String, Integer> rollCount, HashMap<String, Integer> originalOrder) {
        HashMap<String, Integer> newOrder = new HashMap<>();
        for (String roll: originalOrder.keySet()) {
            newOrder.put(roll, rollCount.get(roll));
        }
        return newOrder;
    }
}
