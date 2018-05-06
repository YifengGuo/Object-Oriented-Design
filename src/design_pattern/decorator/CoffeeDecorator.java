package design_pattern.decorator;

/**
 * Created by guoyifeng on 5/5/18.
 */
public abstract class CoffeeDecorator implements Coffee {
    protected final Coffee decoratedCoffee; // the Coffee this add-on added for;
    protected double price;

    public CoffeeDecorator(Coffee coffee) {
        decoratedCoffee = coffee;
    }


    // abstract class does not change with the decorated coffee

    @Override
    public double getCost() {
        return decoratedCoffee.getCost();
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription();
    }
}
