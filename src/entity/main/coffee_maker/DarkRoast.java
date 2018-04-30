package entity.main.coffee_maker;

/**
 * Created by guoyifeng on 4/30/18.
 */
public class DarkRoast extends Coffee {
    private double price;

    public DarkRoast() {
        this.price = 4.59;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getDescription() {
        return "DarkRoast";
    }
}
