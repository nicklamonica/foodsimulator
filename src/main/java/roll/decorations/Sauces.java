package roll.decorations;
import roll.*;

public class Sauces extends RollDecorator {
    Roll roll;

    public Sauces(Roll roll) {
        this.roll = roll;
    }

    public void prepare() {

    }

    public double cost() {
        return 0.20 + roll.cost();
    }
}