package game.main.black_jack;

/**
 * Created by guoyifeng on 5/3/18.
 */
public enum CardValue {
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(10),
    QUEEN(10),
    KING(10),
    ACE(1, 11);

    private int value;

    private int value1;
    private int value2;

    CardValue(int value) {
        this.value = value;
    }

    CardValue(int value1, int value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public int getValue() {
        return value;
    }

    // especially for ACE
    public int getValue1() {
        return value1;
    }

    public int getValue2() {
        return value2;
    }


}
