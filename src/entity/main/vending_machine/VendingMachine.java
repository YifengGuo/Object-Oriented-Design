package entity.main.vending_machine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by guoyifeng on 4/23/18.
 */
public class VendingMachine {
    private List<Item> items; // the items this machine has
    private List<Coin> totalCoins; // the coins this machine holds

    // This map is to maintain the mapping between item code
    // and the info of this code maps to
    // In practice it is the code for a line of items
    // In this design:
    // A1 for Coke, B1 for Sprite, C1 for Pepsi
    private Map<String, ItemInfo> itemIdentifiers;

    private List<Coin> currentInsertedCoins; // inserted coins of the current selection
    private ItemInfo currentSelectedItem;

    private Stock stock;


    public List<Coin> getTotalCoins() {
        return totalCoins;
    }

    public Map<String, ItemInfo> getItemIdentifiers() {
        return itemIdentifiers;
    }

    public List<Coin> getCurrentInsertedCoins() {
        return currentInsertedCoins;
    }

    public void setCurrentInsertedCoins(List<Coin> coins) {
        this.currentInsertedCoins = coins;
    }

    public ItemInfo getCurrentSelectedItem() {
        return currentSelectedItem;
    }

    public Stock getStock() {
        return stock;
    }

    private AbstractState state;
    private NoSelectionState noSelectionState;
    private HasSelectionState hasSelectionState;
    private InsertedCoinsState insertedCoinsState;





    public void setCurrentSelectedItem(String selection) {
        this.currentSelectedItem = itemIdentifiers.get(selection);
    }

    public void insertCoins(List<Coin> coins) {
        currentInsertedCoins.addAll(coins);
        totalCoins.addAll(currentInsertedCoins);
    }

    public void changeToHasSelectionState() {
        this.state = hasSelectionState;
    }

    public void changeToInsertedCoinsState() {
        this.state = insertedCoinsState;
    }

    public void changeToNoSelectionState() {
        this.state = noSelectionState;
    }

    /**
     * run DFS coins combination algorithm and calculate
     * feasible combination for use's refund change
     * @param change
     * @return
     */
    public List<Coin> calculateChange(float change) {
        if (change == 0.0) {
            return new ArrayList<>();
        }
        int penny_left = 0;
        int nickle_left = 0;
        int dime_left = 0;
        int quarter_left = 0;

        for (Coin coin : this.totalCoins) {
            if (coin.getValue() == 1) {
                penny_left++;
            } else if (coin.getValue() == 5) {
                nickle_left++;
            } else if (coin.getValue() == 10) {
                dime_left++;
            } else {
                quarter_left++;
            }
        }

        int coins[] = new int[]{1, 5, 10, 25};
        List<Integer> plan = new ArrayList<>();
        List<List<Integer>> allCombos = new ArrayList<>();
        helper(change, coins, penny_left, nickle_left, dime_left, quarter_left, plan, 0, allCombos);
        if (allCombos.size() == 0) {
            try {
                throw new NotEnoughCoinsException("Not Enough Coins Left");
            } catch (NotEnoughCoinsException e) {
                e.printStackTrace();
            }
        }
        List<Integer> combo = allCombos.get(0);
        List<Coin> res = new ArrayList<>();
        for (int i = 0; i < combo.size(); i++) {
            for (int j = 0; j < combo.get(i); j++) {
                if (i == 0) {
                    res.add(Coin.PENNY);
                } else if (i == 1) {
                    res.add(Coin.NICKLE);
                } else if (i == 2) {
                    res.add(Coin.DIME);
                } else {
                    res.add(Coin.QUARTER);
                }
            }
        }
        return res;
    }

    // run dfs
    private void helper(float target, int[] coins, int penny_left, int nickle_left, int dime_left,
                                       int quarter_left, List<Integer> plan, int level, List<List<Integer>> res) {
        // base case
        if (level == coins.length - 1) {
            if (target % coins[level] == 0) {
                plan.add((int)target / coins[level]);
                if (plan.get(0) <= penny_left && plan.get(1) <= nickle_left &&
                        plan.get(2) <= dime_left && plan.get(3) <= quarter_left) {
                    res.add(new ArrayList<>(plan));
                }
                plan.remove(plan.size() - 1);
            }
            return;
        }
    }
}
