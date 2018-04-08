package management.restaurant.main;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guoyifeng on 4/8/18.
 */
public class Menu {
    private List<Meal> contents;

    public List<Meal> getContents() {
        return this.contents;
    }

    public Menu() {
        contents = new ArrayList<>();
        contents.add(new Meal("Kongpao Chicken", 8.5));
        contents.add(new Meal("Teriyaki Chicken", 10.5));
        contents.add(new Meal("Mapo Toufu", 7.5));
        contents.add(new Meal("Pepper Beef", 9.5));
        contents.add(new Meal("Spicy Chicken", 8.5));
        contents.add(new Meal("Meatball soup", 7.5));
        contents.add(new Meal("Beef Noodle", 8.5));
        contents.add(new Meal("Lamb Soup", 11.5));
        contents.add(new Meal("Ox Tail Ramen", 12.5));
        contents.add(new Meal("Ox Tail Noodle", 12.5));
        contents.add(new Meal("Pork Dumpling", 6.5));
        contents.add(new Meal("Guilin Rice Noodle", 12.5));
        contents.add(new Meal("Egg Fried Rice", 5.5));
        contents.add(new Meal("Eggplant Rice", 4.5));
        contents.add(new Meal("Radish Beef Rice", 8.5));
        contents.add(new Meal("Raised Pork Rice", 7.5));
        contents.add(new Meal("Beef Pie", 4.5));
        contents.add(new Meal("Beef Fried Rice", 7.5));
    }
}
