package store;

import roll.*;

public class RollStore {
    RollFactory rollFactory;

    public RollStore(RollFactory factory){
        this.rollFactory = factory;
    }

    public Roll orderRoll(String type) {
        Roll roll;

        roll = rollFactory.createRoll(type);

        return roll;
    }
}
