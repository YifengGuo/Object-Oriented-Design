package entity.main.coffee_maker;

/**
 * Created by guoyifeng on 4/30/18.
 */
public class HouseBlend extends Coffee {
    private double price;

    public HouseBlend() {
        this.price = 2.99;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getDescription() {
        return "HouseBlend";
    }
}
