package design_pattern.decorator;

/**
 * Created by guoyifeng on 5/5/18.
 */
public class WithMilk extends CoffeeDecorator {

    public WithMilk(Coffee coffee) {
        super(coffee);
        price = 0.5;
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
        return decoratedCoffee.getDescription() + ", Milk";
    }

}
