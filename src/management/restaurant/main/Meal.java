package management.restaurant.main;

/**
 * Created by guoyifeng on 4/8/18.
 */
public class Meal {
    private double price;
    private String name;

    public double getPrice() {
        return this.price;
    }

    public String getName() {
        return name;
    }

    public Meal(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " " + price;
    }
}
