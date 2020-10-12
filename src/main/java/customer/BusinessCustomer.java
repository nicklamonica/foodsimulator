package customer;

import store.RollStore;

import java.util.ArrayList;
import java.util.HashMap;

public class BusinessCustomer extends Customer {
    public BusinessCustomer(RollStore rollStore) {
        super(rollStore);
    }

    // 10 rolls two of each type
    public HashMap<String, Integer> makeRollOrder() {
        HashMap<String,Integer> order = new HashMap<>();

        ArrayList<String> randomRolls = this.getRandomRollTypes(5);
        // add rolls to order
        for (String roll: randomRolls) {
            order.put(roll, 2);
        }
        return order;

    }
}
