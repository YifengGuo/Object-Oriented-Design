package design_pattern.decorator;

/**
 * Created by guoyifeng on 5/5/18.
 */
public class WithGreenTea extends CoffeeDecorator {

    public WithGreenTea(Coffee coffee) {
        super(coffee);
        price = 1.0;
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
        return decoratedCoffee.getDescription() + ", Green Tea";
    }
}
