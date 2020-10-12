package main.java.customer;

import store.RollStore;

import java.util.*;

public abstract class Customer implements customer.StoreObserver {
    protected Random rand = new Random();

    public Customer(RollStore rollStore) {
        rollStore.addObserver(this);
    }

    // gets a random roll types
    protected ArrayList<String> getRandomRollTypes(int numberOfTypes) {
        // create array of all possible types
        ArrayList<String> rollTypes = new ArrayList<String>(){{
            add("egg"); add("jelly"); add("pastry"); add("sausage"); add("spring");
        }};
        // return all types
        if (numberOfTypes >= 5) {
            return rollTypes;
        }
        // get types to return
        ArrayList<String> typesToReturn = new ArrayList<>();
        for (int i = 0; i < numberOfTypes; i++) {
            int idx = rand.nextInt(rollTypes.size());
            typesToReturn.add(rollTypes.get(idx));
            rollTypes.remove(idx);
        }
        return typesToReturn;
    }
}
