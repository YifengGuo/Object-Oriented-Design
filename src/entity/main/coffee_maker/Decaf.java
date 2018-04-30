package entity.main.coffee_maker;

/**
 * Created by guoyifeng on 4/30/18.
 */
public class Decaf extends Coffee{
    private double price;

    public Decaf() {
        this.price = 3.59;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getDescription() {
        return "Decaf";
    }
}
