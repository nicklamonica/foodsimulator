package store;

import customer.StoreObserver;

public interface StoreObservable {
    void addObserver(StoreObserver customer);
    void removeObserver(StoreObserver customer);
    void notifyObservers();
    void setChanged();
}
