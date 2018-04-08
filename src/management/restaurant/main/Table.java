package management.restaurant.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by guoyifeng on 4/8/18.
 */
public class Table {
    private final int cap; // the max number of people this table can hold
    private boolean available;
    private Party party; // maintain which party is currently occupying the table\
    // private List<Order> orders;
    private Menu menu;

    // constructor
    public Table(int cap) {
        menu = new Menu();
        // orders = new ArrayList<>();
        this.available = true;
        this.cap = cap;
    }

    public Menu getMenu() {
        return this.menu;
    }

    public void setParty(Party party) {
        this.party = party;
    }

    public Party getParty() {
        return this.party;
    }

    public boolean isAvailable() {
        return this.available;
    }

    public void markAvailable() {
        this.available = true;
    }

    public void markUnavailable() {
        this.available = false;
    }

    public int getCap() {
        return this.cap;
    }

    public void clear() {
        this.setParty(null);
        this.markAvailable();
    }

    public Order makeOrder() {
        Order o = null;
//        int random_num_dish = (int)(Math.random() * this.getParty().getNum());
        List<Meal> customer_orders = new ArrayList<>();
        for (int i = 0; i < this.getParty().getNum(); i++) {
            int random_index = (int)(Math.random() * this.getMenu().getContents().size());
            customer_orders.add(this.getMenu().getContents().get(random_index));
        }
        o = new Order(customer_orders, this);
        return o;
    }

    /**
     * order specific meal
     * @param m
     * @return
     */
    public Order makeOrder(Meal m) {
        List<Meal> customer_orders = new ArrayList<>();
        customer_orders.add(m);
        Order o = new Order(customer_orders, this);
        return o;
    }
}
