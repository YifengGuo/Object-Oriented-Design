package entity.main.vending_machine;

import java.util.List;
import java.util.Map;

/**
 * Created by guoyifeng on 4/24/18.
 */
public class HasSelectionState extends AbstractState {
    public HasSelectionState(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void selectItem(String selection) {
        this.vendingMachine.setCurrentSelectedItem(selection);
    }

    @Override
    public void insertCoins(List<Coin> coins) {
        this.vendingMachine.insertCoins(coins);
        this.vendingMachine.changeToInsertedCoinsState();
    }

    @Override
    public Map<Item, List<Coin>> executeTransaction() {
        System.out.println("Please Insert Coins First.");
        return null;
    }

    @Override
    public List<Coin> cancelTransaction() {
        System.out.println("Transaction cancelled.");
        this.vendingMachine.setCurrentSelectedItem(null);
        this.vendingMachine.changeToNoSelectionState(); // reset vending machine to NoSelectionState
        return null;
    }
}
