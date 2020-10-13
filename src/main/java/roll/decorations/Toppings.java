package roll.decorations;
import roll.*;

public class Toppings extends RollDecorator {
    Roll roll;

    public Toppings(Roll roll) {
        this.roll = roll;
    }

    public String getDescription() {
        return roll.getDescription() + ", Extra Toppings";
    }

    public double cost() {
        return 0.30 + roll.cost();
    }
}
