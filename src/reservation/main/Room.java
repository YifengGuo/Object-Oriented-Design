package reservation.main;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by guoyifeng on 4/18/18.
 */
public class Room {
    // In our design, we check room's availability by
    // checking if there exists overlap between existed
    // reservation date and current request date
    public static final int DAY = 1*24*60*60*1000;

    private int id;
    private RoomType roomType;
    private Set<Date> reservations;

    public Room(int id, RoomType roomType) {
        this.id = id;
        this.roomType = roomType;
        reservations = new HashSet<>();
    }

    public static int getDAY() {
        return DAY;
    }

    public int getId() {
        return id;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public Set<Date> getReservations() {
        return reservations;
    }

    public boolean isValidRequest(SearchRequest request) {
        Date date = new Date(request.getStartDate().getTime()); // start time
        // keep adding one day time on current request's start date until
        // meets end date and check if internal date is overlapping with
        // exist reservation dates
        for (; date.before(request.getEndDate()); date.setTime(date.getTime() + DAY)) {
            Date tempDate = new Date(date.getTime());
            if (this.getReservations().contains(tempDate)) {
                return false;
            }
        }
        return true;
    }

    /**
     * make reservation on current room, which is to add time internal into this room's reservation set
     * @param startDate
     * @param endDate
     */
    public void makeReservation(Date startDate, Date endDate) {
        Date date = new Date(startDate.getTime());
        for (; date.before(endDate); date.setTime(date.getTime() + DAY)) {
            Date tempDate = new Date(date.getTime());
            this.getReservations().add(tempDate);
        }
    }

    /**
     * cancel reservation on current room, which is to remove time internal from this room's reservation set
     * @param startDate
     * @param endDate
     */
    public void cancelReservation(Date startDate, Date endDate) {
        Date date = new Date(startDate.getTime());
        for (; date.before(endDate); date.setTime(date.getTime() + DAY)) {
            Date tempDate = new Date(date.getTime());
            this.getReservations().remove(tempDate);
        }
    }
}
