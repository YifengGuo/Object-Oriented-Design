package entity.main.coffee_maker;

/**
 * Created by guoyifeng on 4/30/18.
 */
public class Espresso extends Coffee {
    private double price;

    public Espresso() {
        this.price = 3.99;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getDescription() {
        return "Espresso";
    }
}
