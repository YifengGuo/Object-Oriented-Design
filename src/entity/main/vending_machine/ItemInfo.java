package entity.main.vending_machine;

/**
 * Created by guoyifeng on 4/23/18.
 */

/**
 * Helper class for the item
 * Because each item is a dynamic object like a can of Coke.
 * We had better not coupled an real object with some kind of
 * static or final label like its price.
 * So we invoke this class to main some static necessary info for
 * the item
 */
public class ItemInfo {
    private float price;
    private String itemName;

    public ItemInfo(String itemName, float price) {
        this.itemName = itemName;
        this.price = price;
    }

    public float getPrice() {
        return this.price;
    }

    public String getItemName() {
        return itemName;
    }
}
