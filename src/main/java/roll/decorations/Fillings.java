package main.java.roll.decorations;
import main.java.roll.*;

public class Fillings extends RollDecorator {
    Roll roll;

    public Fillings(Roll roll) {
        this.roll = roll;
    }

    public void prepare() {

    }

    public String getDescription() {
        return roll.getDescription() + ", Filling";
    }

    public double cost() {
        return 0.50 + roll.cost();
    }
}
