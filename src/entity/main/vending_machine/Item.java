package entity.main.vending_machine;

/**
 * Created by guoyifeng on 4/23/18.
 */

/**
 * Core Object acts as the output of this system<BR>
 * There are several different kinds of items sold
 * by the vending machine so we need to abstract super
 * class for this part
 */
public class Item {
    protected ItemInfo info;

    public Item() {
        this.info = info;
    }

    public ItemInfo getInfo() {
        return this.info;
    }
}
