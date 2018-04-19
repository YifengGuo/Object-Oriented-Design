package reservation.main;

import java.util.Date;

/**
 * Created by guoyifeng on 4/18/18.
 */

/**
 * User firstly sends SearchRequest to the Hotel and get the <RoomType, List<Room>> info from Hotel.
 * Then user will confirm and send the <RoomType, Integer> info ReservationRequest to the Hotel.
 */
public class SearchRequest {
    private Date startDate;
    private Date endDate;

    public SearchRequest(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    // need to override the hashCode() and equals() for SearchRequest
    // because we need to use it as Key in the LRUCache and need to make sure
    // it is compared by its semantics instead of original hashCode();

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof SearchRequest)) {
            return false;
        }

        SearchRequest searchRequest = (SearchRequest) o;

        return searchRequest.startDate == this.startDate
                && searchRequest.endDate == this.endDate;
    }

    @Override
    public int hashCode() {
        int res = 17;
        res = 31 * res + this.startDate.hashCode();
        res = 31 * res + this.endDate.hashCode();

        return res;
    }
}
