package main.java.roll.decorations;
import main.java.roll.*;

public class Toppings extends RollDecorator {
    Roll roll;

    public Toppings(Roll roll) {
        this.roll = roll;
    }

    public void prepare() {

    }
    public String getDescription() {
        return roll.getDescription() + ", Toppings";
    }

    public double cost() {
        return 0.30 + roll.cost();
    }
}
