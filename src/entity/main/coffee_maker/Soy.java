package entity.main.coffee_maker;

/**
 * Created by guoyifeng on 4/30/18.
 */

/**
 * A kind of add-on (decorator) for Coffee
 */
public class Soy extends CoffeeDecorator {
    public Soy(Coffee coffee) {
        this.coffee = coffee;
        this.price = 0.5;
    }

    @Override
    public double getPrice() {
        return this.price + coffee.getPrice();
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Soy";
    }
}