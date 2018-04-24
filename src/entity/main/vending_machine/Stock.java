package entity.main.vending_machine;

/**
 * Created by guoyifeng on 4/24/18.
 */

import java.util.List;
import java.util.Map;

/**
 * This class is designed based on Adapter Design Pattern
 * The reload or refill process for items in vending machine had better
 * been separated in another helper class for potential extension in the
 * future
 */
public class Stock {
    private Map<ItemInfo, List<Item>> stock; // current item and its remaining amount

    private static final int DEFAULT_LOAD_SIZE = 10;

    public int getQuantity(ItemInfo info) {
        return stock.get(info).size();
    }

    public void add(Item item) {
        stock.get(item.getInfo()).add(item);
    }

    public Item deduct(ItemInfo info) {
        return stock.get(info).remove(0); // remove one item when selling one
    }

    public Map<ItemInfo, List<Item>> getStock() {
        return stock;
    }

    public void reload(ItemInfo info) {
        for (int i = 0; i < DEFAULT_LOAD_SIZE; i++) {
            if (info.getItemName().equals("Coke")) {
                stock.get(info).add(new Coke());
            } else if (info.getItemName().equals("Sprite")) {
                stock.get(info).add(new Sprite());
            } else {
                stock.get(info).add(new Pepsi());
            }
        }
    }

}
