
import customer.*;
import store.RollStore;

public class Main {

    public static void main(String[] args) {
        // init roll store
        RollStore rollStore = new RollStore();



        // TODO create a random amount of customers for each day
        new CasualCustomer(rollStore);
        new CasualCustomer(rollStore);
        new CasualCustomer(rollStore);
        new CateringCustomer(rollStore);
        new BusinessCustomer(rollStore);

        // run for 30 days,
        for (int day = 1; day <= 30; day++) {
          rollStore.openForADay(day);
        }
    }
}
