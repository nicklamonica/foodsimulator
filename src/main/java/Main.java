
import customer.*;
import store.RollStore;

public class Main {

    public static void main(String[] args) {
        // init roll store
        RollStore rollStore = new RollStore();
        CustomerFactory customerFactory = new CustomerFactory();

        // run for 30 days,
        for (int day = 1; day <= 30; day++) {
            customerFactory.createCustomers(rollStore);
            rollStore.openForADay(day);
        }
    }
}
