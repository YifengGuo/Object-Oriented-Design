package entity.main.coffee_maker;

/**
 * Created by guoyifeng on 4/30/18.
 */

/**
 * A kind of add-on (decorator) for Coffee
 */
public class Soy extends CoffeeDecorator {
    public Soy() {
        this.price = 0.5;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String getDescription() {
        return "Soy";
    }
}