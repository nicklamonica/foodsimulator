package roll.types;

import roll.*;

public class EggRoll extends Roll {

    @Override
    public void prepare() {

    }

    @Override
    public double cost() {
        return 0;
    }

    public EggRoll() {
        description = "Egg Roll";
    }
}
