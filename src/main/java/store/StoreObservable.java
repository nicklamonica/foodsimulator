package store;

import customer.StoreObserver;

public interface StoreObservable {
    void addObserver(StoreObserver customer);
    void removeObservers();
    void notifyObservers();
}
