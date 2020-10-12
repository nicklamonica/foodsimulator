package customer;

import store.RollStore;

import java.util.ArrayList;
import java.util.Random;

public class CustomerFactory {

    Random rand = new Random();

    public void createCustomers(RollStore rollStore) {
        int numCasual = rand.nextInt(12)+1;
        for (int i = 0; i < numCasual; i++) {
            new CasualCustomer(rollStore);
        }
        int numBusiness = rand.nextInt(3)+1;
        for (int i = 0; i < numBusiness; i++) {
            new BusinessCustomer(rollStore);
        }
        int numCatering = rand.nextInt(3)+1;
        for (int i = 0; i < numCatering; i++) {
            new CateringCustomer(rollStore);
        }
    }
}
