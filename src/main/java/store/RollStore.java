package store;

import customer.StoreObserver;
import roll.*;

import java.util.ArrayList;
import java.util.HashMap;


public class RollStore implements StoreObservable {
    ArrayList<StoreObserver> customers;
    RollStoreInventory rollStoreInventory;
    HashMap<String, Integer> numSold;
    private double totalSales = 0.0;

    public RollStore(){
        this.customers = new ArrayList<>();
        this.rollStoreInventory = new RollStoreInventory();
    }

    public void openForADay(int day) {
        System.out.printf("\n====== Day %d ======\n", day);
        // reset number of rolls sold for the  day
        this.numSold = new HashMap<String, Integer>(){{
            put("egg", 0); put("jelly", 0); put("pastry", 0); put("sausage", 0); put("spring", 0);
        }};

        // check and restock empty roll inventory
        this.rollStoreInventory.restockInventory();

        // take customers
        this.notifyObservers();

        // print everything at the end of the day
        this.rollStoreInventory.getInventory();
        this.getSalesData();

        // TODO get rid of the observers of the store at the end of the day
//        for (StoreObserver customer: customers) {
//            this.removeObserver(customer);
//        }
        System.out.printf("==== End Of Day %d ====\n", day);
    }

    /********* Getters and setters ***********/
    public void getSalesData(){

        StringBuilder out = new StringBuilder();
        out.append("Sales Data:\n");
        for (String roll: this.numSold.keySet()){
            out.append("Number of ").append(roll).append(" rolls sold: ").append(this.numSold.get(roll)).append("\n");
        }
        out.append("Total Sales = ").append(totalSales);
        System.out.println(out);
    }



    /********** functions for making orders ***********/
    private void fillOrder(HashMap<String, Integer> order) {
        if (order == null) {
            return;
        }
        // take the order from inventory
        for (String roll: order.keySet()) {
            for (int i = 0; i < order.get(roll); i++) {
                Roll purchasedRoll = this.rollStoreInventory.popRoll(roll);
                // record total sales
                this.totalSales += purchasedRoll.cost();
                // record the rolls sold
                this.numSold.put(roll,this.numSold.get(roll) + 1);
            }
        }
    }

    // make sure we have the proper order
    private boolean validateOrder(HashMap<String, Integer> order) {
        for (String roll: order.keySet()){
            // invalidate if there are more in the order than are left in the inventory left;
            if (order.get(roll) > this.rollStoreInventory.getNumberOfRolls(roll)) {
                return false;
            }
        }
        return true;
    }

    /********** Observable functions ************/
    // add customers to the store
    public void addObserver(StoreObserver customer) {
        this.customers.add(customer);
    }

    // remove customers
    public void removeObserver(StoreObserver customer) {
        this.customers.remove(customer);
    }

    // tell observers store is open, get orders.
    public void notifyObservers() {
        for (StoreObserver customer: this.customers) {
            HashMap<String, Integer> order =  customer.makeRollOrder();
            if (!this.validateOrder(order)) {
                // TODO: create another store observer function that handles an invalidated order
                order = null;
            }
            this.fillOrder(order);
        }
    }

    // ???
    public void setChanged() { }
}
