package entity.main.vending_machine;

/**
 * Created by guoyifeng on 4/23/18.
 */

/**
 * Core Object acts as input of this system<BR>
 * The US coin usually has 4 different types which
 * should be designed as enumeration
 */
public enum Coin {
    PENNY(1),
    NICKLE(5),
    DIME(10),
    QUARTER(25);

    private int value;

    Coin(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
