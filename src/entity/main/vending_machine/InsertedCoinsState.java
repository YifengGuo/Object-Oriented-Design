package entity.main.vending_machine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by guoyifeng on 4/24/18.
 */
public class InsertedCoinsState extends AbstractState {
    public InsertedCoinsState(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void selectItem(String selection) {
        System.out.println("You Have Already Selected An Item. Please Cancel Current Transaction And " +
                "Make Another Selection");
    }

    @Override
    public void insertCoins(List<Coin> coins) {
        this.vendingMachine.insertCoins(coins);
    }

    @Override
    public Map<Item, List<Coin>> executeTransaction() {
        float currentCoins = 0.0f;
        Item item = null;
        for (Coin coin : this.vendingMachine.getCurrentInsertedCoins()) {
            currentCoins += coin.getValue();
        }
        float price = this.vendingMachine.getCurrentSelectedItem().getPrice();
        if (currentCoins >= price) {
            item = this.vendingMachine.getStock().deduct(vendingMachine.getCurrentSelectedItem());
            if (this.vendingMachine.getStock().getStock().get(this.vendingMachine.
                    getCurrentSelectedItem()).size() == 0) {
                this.vendingMachine.getStock().reload(this.vendingMachine.getCurrentSelectedItem());
            }
        }
        float change = currentCoins - price;
        List<Coin> coinsCombination = vendingMachine.calculateChange(change);
        Map<Item, List<Coin>> res = new HashMap<>();
        res.put(item, coinsCombination);
        return res;
    }

    @Override
    public List<Coin> cancelTransaction() {
        this.vendingMachine.getTotalCoins().removeAll(this.vendingMachine.getCurrentInsertedCoins());
        List<Coin> res = this.vendingMachine.getCurrentInsertedCoins();
        this.vendingMachine.setCurrentInsertedCoins(new ArrayList<>());
        this.vendingMachine.setCurrentSelectedItem(null);
        this.vendingMachine.changeToNoSelectionState();
        System.out.println("Transaction Cancelled");
        return res;
    }
}
