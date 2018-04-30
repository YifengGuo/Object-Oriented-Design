package entity.main.vending_machine;

/**
 * Created by guoyifeng on 4/23/18.
 */
public class Sprite extends Item {
    private ItemInfo spriteInfo;

    public Sprite() {
        this.spriteInfo = new ItemInfo("Sprite", 159f);
    }

    public ItemInfo getSpriteInfo() {
        return this.info;
    }
}
