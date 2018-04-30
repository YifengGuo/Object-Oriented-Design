package entity.main.coffee_maker;

/**
 * Created by guoyifeng on 4/30/18.
 */

/**
 * A kind of add-on (decorator) for Coffee
 */
public class Mocha extends CoffeeDecorator {

    public Mocha(Coffee coffee) {
        this.coffee = coffee;
        this.price = 1.00;
    }

    @Override
    public double getPrice() {
        return this.price + coffee.getPrice();
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Mocha";
    }
}
