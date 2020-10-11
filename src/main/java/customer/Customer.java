package customer;

import java.util.*;

public abstract class Customer {
    protected Random rand = new Random();

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

    public abstract HashMap<String, Integer> makeRollOrder();
}
