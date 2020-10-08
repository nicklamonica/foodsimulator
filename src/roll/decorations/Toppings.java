package roll.decorations;
import roll.*;

public class Toppings extends RollDecorator {
    Roll roll;

    public Toppings(Roll roll) {
        this.roll = roll;
    }

    public void prepare() {

    }

    public double cost() {
        return 0.30 + roll.cost();
    }
}