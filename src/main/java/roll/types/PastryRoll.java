package roll.types;

import roll.*;

public class PastryRoll extends Roll {
    public PastryRoll() {
        description = "Pastry Roll";
    }

    @Override
    public double cost() {
        return 0;
    }
}
