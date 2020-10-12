package roll;

public abstract class Roll {
    public String description = "";

    public abstract void prepare();

    public abstract double cost();

    public String getDescription() {
        return description;
    }
}
