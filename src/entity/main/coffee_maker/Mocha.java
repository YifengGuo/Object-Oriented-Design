package entity.main.coffee_maker;

/**
 * Created by guoyifeng on 4/30/18.
 */

/**
 * A kind of add-on (decorator) for Coffee
 */
public class Mocha extends CoffeeDecorator {

    public Mocha() {
        this.price = 1.00;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String getDescription() {
        return "Mocha";
    }
}
