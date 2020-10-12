import customer.BusinessCustomer;
import customer.CasualCustomer;
import customer.CateringCustomer;
import customer.Customer;
import roll.RollFactory;
import store.RollStore;

public class Main {

    public static void main(String[] args) {
        RollStore rollStore = new RollStore(new RollFactory());
        new CasualCustomer(rollStore);
        new CasualCustomer(rollStore);
        new CasualCustomer(rollStore);
        new CateringCustomer(rollStore);
        new BusinessCustomer(rollStore);
        rollStore.openForADay(1);
    }
}
