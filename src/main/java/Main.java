import customer.BusinessCustomer;
import customer.CasualCustomer;
import customer.CateringCustomer;
import customer.Customer;
import roll.RollFactory;
import store.RollStore;

public class Main {

    public static void main(String[] args) {
        RollStore rollStore = new RollStore(new RollFactory());
        Customer customer1 = new CasualCustomer(rollStore);
        Customer customer2 = new CasualCustomer(rollStore);
        Customer customer3 = new CasualCustomer(rollStore);
        Customer customer4 = new CateringCustomer(rollStore);
        Customer customer5 = new BusinessCustomer(rollStore);
        rollStore.notifyObservers();
        rollStore.getInventory();
    }
}
