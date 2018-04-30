package entity.main.coffee_maker;

/**
 * Created by guoyifeng on 4/30/18.
 */
public class CoffeePack {
    private Coffee coffee;

    public CoffeePack(Coffee coffee) {
        this.coffee = coffee;
    }

    public Coffee getCoffee() {
        return coffee;
    }

    public String getDescription() {
        return coffee.getDescription();
    }
}
