package management.restaurant.main;

import java.util.List;

/**
 * Created by guoyifeng on 4/8/18.
 */
public class Order {
    private List<Meal> meals;
    private Table t; // represents the belonging of this order
    private Party p; // represents the initiator of this order

    public Order(List<Meal> meals, Table t) {
        this.meals = meals;
        this.t = t;
    }


    public double getPrice() {
        double res = 0.0;
        for (Meal m : meals) {
            res += m.getPrice();
        }
        return res;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public Table getT() {
        return t;
    }

    public Party getP() {
        return p;
    }

}
