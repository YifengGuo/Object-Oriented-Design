package reservation.main;

/**
 * Created by guoyifeng on 4/19/18.
 */

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * to test the BookingSystem
 */
public class Test {
    private static final int DAY = 1 * 24 * 60 * 60 * 1000;
    public static void main(String[] args) {
        BookingSystem bs = BookingSystem.getInstance();

        // first request with 15 people to live 5 days
        SearchHotelRequest searchHotelRequest1 = new SearchHotelRequest(
                new Date(System.currentTimeMillis()),
                new Date(System.currentTimeMillis() + 5 * DAY),
                15);
        List<Hotel> hotels1 = bs.searchHotels(searchHotelRequest1);

        for (Hotel h : hotels1) {
            System.out.print(h + ", ");
        }

        System.out.println();

        // test 15 people split into 5 double rooms and 5 single rooms
        Map<RoomType, Integer> roomsNeeded1 = new HashMap<>();
        roomsNeeded1.put(RoomType.DOUBLE, 5);
        roomsNeeded1.put(RoomType.SINGLE, 5);
        bs.makeReservation(hotels1.get(0), new ReservationRequest(searchHotelRequest1.getStartDate(),
                searchHotelRequest1.getEndDate(), roomsNeeded1));

        for (Room room : hotels1.get(0).getRooms()) {
            for (Date date : room.getReservations()) {
                System.out.print("room type: " + room.getRoomType() + " " + "date: " + date + " ");
            }
            System.out.println();
        }

        // test Exception
        SearchHotelRequest searchHotelRequest2 = new SearchHotelRequest(
                new Date(System.currentTimeMillis()),
                new Date(System.currentTimeMillis() + 5 * DAY),
                15000);

        bs.searchHotels(searchHotelRequest2); //  No suitable hotel found!

        // fill up one hotel and try to make reservation to it

        Hotel hotel2 = bs.getHotels().get(1);
        Map<RoomType, Integer> roomsNeeded2 = new HashMap<>();
        roomsNeeded2.put(RoomType.DOUBLE, 10);
        roomsNeeded2.put(RoomType.SINGLE, 20);

        bs.makeReservation(hotel2, new ReservationRequest(searchHotelRequest1.getStartDate(),
                searchHotelRequest1.getEndDate(), roomsNeeded2));

        bs.makeReservation(hotel2,new ReservationRequest(searchHotelRequest1.getStartDate(),
                searchHotelRequest1.getEndDate(), roomsNeeded1));


    }



}
