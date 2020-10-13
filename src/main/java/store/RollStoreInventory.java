package store;

import roll.Roll;
import roll.RollFactory;

import java.util.ArrayList;
import java.util.HashMap;

public class RollStoreInventory {

    private final HashMap<String, ArrayList<Roll>> inventory;
    private final RollFactory rollFactory;

    public RollStoreInventory() {
        this.rollFactory = new RollFactory();
        // init inventory, which is a map of strings to Roll array
        this.inventory = new HashMap<>();
        ArrayList<Roll> initEggRolls = this.restockRoll("egg");
        ArrayList<Roll> initJellyRolls = this.restockRoll("jelly");
        ArrayList<Roll> initPastryRolls = this.restockRoll("pastry");
        ArrayList<Roll> initSausageRolls = this.restockRoll("sausage");
        ArrayList<Roll> initSpringRolls = this.restockRoll("spring");

        this.inventory.put("egg", initEggRolls);
        this.inventory.put("jelly", initJellyRolls);
        this.inventory.put("pastry", initPastryRolls);
        this.inventory.put("sausage", initSausageRolls);
        this.inventory.put("spring", initSpringRolls);
    }

    /*********** Public inventory methods ***************/
    public void restockInventory() {
        for (String roll: inventory.keySet() ) {
            if (this.getNumberOfRolls(roll) == 0 ) {
                this.inventory.put(roll, this.restockRoll(roll));
            }
        }
    }

    public void printInventory() {
        StringBuilder out = new StringBuilder();
        out.append("Inventory Data:\n");
        for (String roll: this.inventory.keySet()) {
            out.append("Number of ").append(roll).append(" rolls left: ").append(this.inventory.get(roll).size()).append("\n");
        }
        System.out.println(out);
    }

    public HashMap<String, Integer> getRollCount() {
        HashMap<String, Integer> count = new HashMap<>();
        for (String roll: this.inventory.keySet()) {
            count.put(roll, this.getNumberOfRolls(roll));
        }
        return count;
    }

    public int getNumberOfRolls(String roll) {
        return this.inventory.get(roll).size();
    }

    public Roll popRoll(String roll) {
        int index = this.inventory.get(roll).size()-1;
        return this.inventory.get(roll).remove(index);
    }


    /************** Private inventory methods *************/

    private ArrayList<Roll> restockRoll(String rollType) {
        ArrayList<Roll> rolls = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            rolls.add(this.createRoll(rollType));
        }
        return rolls;
    }

    // create a new roll from factory
    private Roll createRoll(String rollType) {
        Roll roll;
        roll = rollFactory.createRoll(rollType);
        return roll;
    }

}
