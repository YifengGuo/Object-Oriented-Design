package entity.main.coffee_maker;

/**
 * Created by guoyifeng on 4/30/18.
 */

/**
 * Decorator Design Pattern
 *
 * This is for add-ons of different kinds of Coffee without changing
 * the structure of Coffee itself
 */
public abstract class CoffeeDecorator extends Coffee {
    protected Coffee coffee;
    protected double price;

    public abstract double getPrice();
    public abstract String getDescription();
}
