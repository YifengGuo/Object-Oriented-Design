package entity.main.vending_machine;

/**
 * Created by guoyifeng on 4/23/18.
 */
public class Pepsi extends Item {
    private ItemInfo pepsiInfo;

    public Pepsi() {
        this.pepsiInfo = new ItemInfo("Pepsi", 1.69f);
    }

    public ItemInfo getInfo() {
        return this.pepsiInfo;
    }
}
