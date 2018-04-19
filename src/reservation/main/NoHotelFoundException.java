package reservation.main;

/**
 * Created by guoyifeng on 4/19/18.
 */
public class NoHotelFoundException extends Exception {
    public NoHotelFoundException(String msg) {
        super(msg);
    }
}
