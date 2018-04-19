package reservation.main;

/**
 * Created by guoyifeng on 4/19/18.
 */

import java.util.Date;

/**
 * The first search request sent by user to the BookingSystem
 * which is to select which hotel (or city) to live in <br>
 * After this request is handled, the user can start to send
 * SearchRequest and ReservationRequest to the hotel to search
 * and confirm reservation on selected rooms
 */
public class SearchHotelRequest {
    private Date startDate;
    private Date endDate;
    private int groupSize; // how many people to handle

    public SearchHotelRequest(Date startDate, Date endDate, int groupSize) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.groupSize = groupSize;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public int getGroupSize() {
        return groupSize;
    }
}
