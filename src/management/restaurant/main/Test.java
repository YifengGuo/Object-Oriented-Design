package management.restaurant.main;

import java.util.List;

/**
 * Created by guoyifeng on 4/8/18.
 */
public class Test {
    public static void main(String[] args) {
        Restaurant restaurant = Restaurant.getInstance();
        Party party1 = new Party(4);
        Table table1 = restaurant.findTable(party1);

        Order table1Order = table1.makeOrder();
        restaurant.takeOrder(table1Order);
        printOrderedMeals(restaurant.getOrders().get(table1));

        restaurant.checkout(table1);
        assert table1.isAvailable() == false;

        // Exception test passed
//        Party party2 = new Party(6);
//        Table table2 = restaurant.findTable(party2);

        Party party3 = new Party(5);
        Table table3 = restaurant.findTable(party3);
        Order table3Order = table3.makeOrder();
        restaurant.takeOrder(table3Order);
        printOrderedMeals(restaurant.getOrders().get(table3));
        restaurant.takeOrder(table3.makeOrder(table3.getMenu().getContents().get(6)));
        printOrderedMeals(restaurant.getOrders().get(table3));
        double totalPriceTable3 = restaurant.checkout(table3);
        System.out.println(totalPriceTable3);

    }

    public static void printOrderedMeals(List<Order> orderList) {
        for (Order o : orderList) {
            for (Meal m : o.getMeals()) {
                System.out.println(m);
            }
        }
        System.out.println("\n");
    }
}
