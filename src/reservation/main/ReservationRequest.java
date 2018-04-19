package reservation.main;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by guoyifeng on 4/18/18.
 */

/**
 * When user firstly sends search request to hotel and get some room info,
 * if the rooms are enough, the user can send reservation request to hotel
 * which wraps the date and needed room info to the hotel and let the hotel
 * confirm the request and make reservation for user.
 */
public class ReservationRequest {
    private Date startDate;
    private Date endDate;
    private Map<RoomType, Integer> roomsNeeded;

    public ReservationRequest(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
        roomsNeeded = new HashMap<>();
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Map<RoomType, Integer> getRoomsNeeded() {
        return roomsNeeded;
    }
}
