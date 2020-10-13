package customer;

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

    // catering customer takes as many as it can up till 15
    public HashMap<String, Integer> makeModifiedRollOrder(HashMap<String, Integer> rollCount, HashMap<String, Integer> originalOrder) {
        HashMap<String, Integer> newOrder = new HashMap<>();
        int total = 0;
        // handle overtaking roll amounts
        for (String roll: originalOrder.keySet()) {
            int numToGet = Math.min(rollCount.get(roll), originalOrder.get(roll));
            newOrder.put(roll, numToGet);
            rollCount.put(roll, rollCount.get(roll) - numToGet);
            total += numToGet;
            // delete roll from roll count if 0
            if (rollCount.get(roll) == 0) {
                rollCount.remove(roll);
            }
        }

        // fill to 15
        for (String roll: rollCount.keySet()) {

        }

        return newOrder;
    }
}
