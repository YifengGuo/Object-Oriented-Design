package entity.main.vending_machine;

import java.util.List;
import java.util.Map;

/**
 * Created by guoyifeng on 4/24/18.
 */
public class NoSelectionState extends AbstractState {
    public NoSelectionState(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void selectItem(String selection) {
        this.vendingMachine.setCurrentSelectedItem(selection);
        this.vendingMachine.changeToHasSelectionState(); // change vending machine state to HasSelectionState
    }

    @Override
    public void insertCoins(List<Coin> coins) {
        System.out.println("Please Make A Selection Before Inserting Coins.");
    }

    @Override
    public Map<Item, List<Coin>> executeTransaction() {
        System.out.println("Please Make A Selection First.");
        return null;
    }

    @Override
    public List<Coin> cancelTransaction() {
        System.out.println("Please Make A Selection First.");
        return null;
    }
}
