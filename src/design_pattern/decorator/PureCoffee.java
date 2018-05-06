package design_pattern.decorator;

/**
 * Created by guoyifeng on 5/5/18.
 */
public class PureCoffee implements Coffee {
    private double cost;
    private String ingredient;

    public PureCoffee() {
        cost = 1.99;
        ingredient = "Pure Coffee";
    }

    @Override
    public double getCost() {
        return cost;
    }

    @Override
    public String getDescription() {
        return ingredient;
    }

}
