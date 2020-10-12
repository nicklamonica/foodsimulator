package main.java.customer;

import store.RollStore;

import java.util.ArrayList;
import java.util.HashMap;

public class CateringCustomer extends Customer {
    public CateringCustomer(RollStore rollStore) {
        super(rollStore);
    }

    // 5 rolls of 3 different types, the 3 types chosen randomly
    public HashMap<String, Integer> makeRollOrder() {
        HashMap<String,Integer> order = new HashMap<>();

        ArrayList<String> randomRolls = this.getRandomRollTypes(3);
        // add rolls to order
        for (String roll: randomRolls) {
            order.put(roll, 5);
        }
        return order;
    }
}
