package reservation.main;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by guoyifeng on 4/18/18.
 */
public class Reservation {
    private Hotel hotel;
    private Date startDate;
    private Date endDate;
    private List<Room> rooms;

    public Reservation(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
        rooms = new ArrayList<>();
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    @Override
    public String toString() {
            String res = "Hotel is: " + hotel.getId() + ", start date is: " +
                    DateFormat.getDateInstance().format(startDate) + ", End date is: " +
                    DateFormat.getDateInstance().format(endDate) + ", rooms are: ";

        for(Room room : rooms) {
            res += room.getId() + "; ";
        }

        res += ". ";

        return res;
    }
}
