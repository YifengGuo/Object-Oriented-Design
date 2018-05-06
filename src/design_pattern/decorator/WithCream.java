package design_pattern.decorator;

/**
 * Created by guoyifeng on 5/5/18.
 */
public class WithCream extends CoffeeDecorator {
    public WithCream(Coffee coffee) {
        super(coffee);
        price = 0.3;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + price;
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Cream";
    }
}
