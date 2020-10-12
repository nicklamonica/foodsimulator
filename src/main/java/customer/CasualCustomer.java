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
}
