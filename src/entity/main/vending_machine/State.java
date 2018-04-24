package entity.main.vending_machine;

import java.util.List;
import java.util.Map;

/**
 * Created by guoyifeng on 4/24/18.
 */

/**
 * This interface is design by State Design Pattern
 * Because a vending machine may have several different states
 * and we need to have different handle strategies on each state.
 * So a vending machine should have each different states and each
 * state should implement the functions(handle strategies) in State
 * interface
 */
public interface State {
    void selectItem(String selection);
    void insertCoins(List<Coin> coins);
    Map<Item, List<Coin>> executeTransaction(); // Item user's selected and changes
    List<Coin> cancelTransaction();
}
