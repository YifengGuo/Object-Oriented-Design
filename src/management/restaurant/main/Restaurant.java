package management.restaurant.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by guoyifeng on 4/8/18.
 */
public class Restaurant {
    private List<Table> tables;
    private Menu menu;
    private Map<Table, List<Order>> orders;

    private static final int DEFAULT_TABLE_NUM = 20;
    private static final int DEFAULT_TABLE_CAPACITY = 5;

    public List<Table> getTables() {
        return tables;
    }

    public Menu getMenu() {
        return menu;
    }

    public Map<Table, List<Order>> getOrders() {
        return orders;
    }


    // Singleton for Restaurant
    private static final Restaurant INSTANCE = new Restaurant();

    private Restaurant() {
        tables = new ArrayList<>();
        for (int i = 0; i < DEFAULT_TABLE_NUM; i++) {
            tables.add(new Table(DEFAULT_TABLE_CAPACITY));
        }

        menu = new Menu();

        orders = new HashMap<>();
    }

    public static Restaurant getInstance() {
        return INSTANCE;
    }


    public Table findTable(Party p) {
        Table res = null;
        for (Table t : tables) {
            if (t.isAvailable() && t.getCap() >= p.getNum()) {
                res = t;
            }
        }
        if (res == null) {
            try {
                throw new NoSuitableTableException("No suitable table left right now");
            } catch (NoSuitableTableException e) {
                e.printStackTrace();
            }
        }
        res.setParty(p);
        res.markUnavailable();
        return res;
    }

    public void takeOrder(Order o) {
        if (!this.getOrders().containsKey(o.getT())) {
            this.getOrders().put(o.getT(), new ArrayList<>());
            this.getOrders().get(o.getT()).add(o);
        } else {
            this.getOrders().get(o.getT()).add(o); // add the order to current table's orders
        }
        // List<Meal> res = new ArrayList<>();
//        for (Meal m : o.getMeals()) {
//            res.add(m);
//        }
        // return res;
    }

    /**
     * checkout the bill of given order and clear up the table belonging to the order
     * @param t
     */
    public double checkout(Table t) {
        List<Order> orders = this.getOrders().get(t); // orders made by this table
        double totalPrice = 0.0;
        for (Order o : orders) {
            totalPrice += o.getPrice();
        }
        this.getOrders().remove(t);
        t.clear();
        return totalPrice;
    }
}
