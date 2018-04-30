package entity.main.coffee_maker;

/**
 * Created by guoyifeng on 4/30/18.
 */

/**
 * Test program for Coffee Maker
 */
public class Test {
    public static void main(String[] args) {
        CoffeeMaker coffeeMaker = new CoffeeMaker();
        CoffeePack coffeePack1 = new CoffeePack(new Espresso());

        Coffee coffee1 = coffeeMaker.makeCoffee(coffeePack1);
        System.out.println(coffee1.getDescription() + " $" + coffee1.getPrice());

        Coffee coffee2 = new Milk(coffee1);
        System.out.println(coffee2.getDescription() + " $" + coffee2.getPrice());

        Coffee coffee3 = new Mocha(coffee2);
        System.out.println(coffee3.getDescription() + " $" + coffee3.getPrice());
    }
}
