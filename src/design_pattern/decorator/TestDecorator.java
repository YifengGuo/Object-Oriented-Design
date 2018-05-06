package design_pattern.decorator;

/**
 * Created by guoyifeng on 5/5/18.
 */

/**
 * In object-oriented programming, the decorator pattern is a design pattern that allows behavior to be added to an
 * individual object, either statically or dynamically, without affecting the behavior of other objects from the same
 * class.[1] The decorator pattern is often useful for adhering to the Single Responsibility Principle, as it allows
 * functionality to be divided between classes with unique areas of concern.[2] The decorator pattern is structurally
 * nearly identical to the chain of responsibility pattern, the difference being that in a chain of responsibility,
 * exactly one of the classes handles the request, while for the decorator, all classes handle the request.
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
