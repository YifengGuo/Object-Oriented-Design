package reservation.main;

/**
 * Created by guoyifeng on 4/19/18.
 */
import java.util.*;

/**
 * To test usage of API in Java Date
 */
public class DateTest {
    public static void main(String[] args) {
        long DAY = 1 * 24 * 60 * 60 * 1000;  // day time in milli seconds
        Date date = new Date(System.currentTimeMillis());
        Date endDate = new Date(System.currentTimeMillis() + 5 * DAY);
        Set<Date> set = new HashSet<>();
        for (; date.before(endDate); date.setTime(date.getTime() + DAY)) {
            Date tmp = new Date(date.getTime());
            set.add(tmp);
        }

        for (Date d : set) {
            System.out.println(d);
        }
    }
}
