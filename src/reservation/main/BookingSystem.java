package reservation.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by guoyifeng on 4/19/18.
 */

/**
 * The core object BookingSystem of this design
 * This class is to handle the SearchHotelRequest and cancel reservation operation
 */
public class BookingSystem {
    private List<Hotel> hotels;
    private static final int DEFAULT_HOTEL_COUNT = 20; // set default hotel count of system with 20

    public List<Hotel> getHotels() {
        return hotels;
    }

    private static final BookingSystem Instance = new BookingSystem();

    public static BookingSystem getInstance() {
        return Instance;
    }

    private BookingSystem() {
        hotels = new ArrayList<>();
        for (int i = 0; i < DEFAULT_HOTEL_COUNT; i++) {
            hotels.add(new Hotel(i));
        }
    }


    public List<Hotel> searchHotels(SearchHotelRequest request) {
        int groupSize = request.getGroupSize();

        // send search request to each hotel of this system
        SearchRequest searchRequest = new SearchRequest(request.getStartDate(), request.getEndDate());

        List<Hotel> res = new ArrayList<>();

        for (Hotel hotel : this.getHotels()) {
            Map<RoomType, List<Room>> availableRooms = hotel.handleSearchRequst(searchRequest);
            int availableCapacity = 0;
            // traverse on each hotel to see if it can hold this group of people with
            // its available rooms
            // further check with specific room type will be checked during reservation making process
            for (Map.Entry<RoomType, List<Room>> entry : availableRooms.entrySet()) {
                availableCapacity += entry.getKey().getCapacity() * entry.getValue().size();
            }

            if (availableCapacity >= groupSize) {
                res.add(hotel);
            }
        }
        return res;
    }

    public Reservation makeReservation(Hotel hotel, ReservationRequest request) {
        return hotel.makeReservation(request);
    }

    public void cancelReservation(Reservation reservation) {
        reservation.getHotel().cancelReservation(reservation);
    }
}


