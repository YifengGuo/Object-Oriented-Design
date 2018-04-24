package entity.main.vending_machine;

/**
 * Created by guoyifeng on 4/24/18.
 */

/**
 * abstract super class for all the different states of vending machine
 */
public abstract class AbstractState implements State {
    protected VendingMachine vendingMachine;

    public AbstractState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }
}
