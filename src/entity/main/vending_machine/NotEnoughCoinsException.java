package entity.main.vending_machine;

/**
 * Created by guoyifeng on 4/24/18.
 */
public class NotEnoughCoinsException extends Exception {
    public NotEnoughCoinsException(String msg) {
        super(msg);
    }
}
