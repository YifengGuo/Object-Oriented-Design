package reservation.main;

/**
 * Created by guoyifeng on 4/19/18.
 */
public class RoomNotEnoughException extends Exception {
    public RoomNotEnoughException(String msg) {
        super(msg);
    }
}
