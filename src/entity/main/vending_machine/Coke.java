package entity.main.vending_machine;

/**
 * Created by guoyifeng on 4/23/18.
 */
public class Coke extends Item {
    private ItemInfo cokeInfo;

    public Coke() {
        cokeInfo = new ItemInfo("Coke", 1.99f);
    }

    public ItemInfo getCokeInfo() {
        return this.cokeInfo;
    }
}
