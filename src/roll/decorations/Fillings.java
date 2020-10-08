package roll.decorations;
import roll.*;

public class Fillings extends RollDecorator {
    Roll roll;

    public Fillings(Roll roll) {
        this.roll = roll;
    }

    public void prepare() {

    }

    public double cost() {
        return 0.50 + roll.cost();
    }
}
