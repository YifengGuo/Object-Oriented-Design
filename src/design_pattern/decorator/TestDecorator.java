package design_pattern.decorator;

/**
 * Created by guoyifeng on 5/5/18.
 */
public class TestDecorator {
    public static void main(String[] args) {
        Coffee coffee = new PureCoffee();
        System.out.println(coffee.getDescription() + " " + coffee.getCost());
        coffee = new WithMilk(coffee);
        System.out.println(coffee.getDescription() + " " + coffee.getCost());
        coffee = new WithCream(coffee);
        System.out.println(coffee.getDescription() + " " + coffee.getCost());
        coffee = new WithGreenTea(coffee);
        System.out.println(coffee.getDescription() + " " + coffee.getCost());
    }
}
