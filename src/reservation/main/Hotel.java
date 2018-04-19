package reservation.main;

import elevator.main.Request;

import java.util.*;

/**
 * Created by guoyifeng on 4/18/18.
 */
public class Hotel {
    private int id;
    private List<Room> rooms;
    // private Map<Room, List<Date>> roomReservations; // each room itself maintains the reservation time info
    private LRUCache cache;

    public Hotel(int id) {
        this.id = id;
        rooms = new ArrayList<>();
        cache = new LRUCache(2);
    }

    public int getId() {
        return id;
    }

    public List<Room> getRooms() {
        return this.rooms;
    }

    /**
     * given SearchRequest with start date and end date, return RoomType and its left rooms
     * in this hotel. This function is used when LRUCache did not cache current SearchRequest
     * @param r
     * @return
     */
    private Map<RoomType, List<Room>> getAvailableRooms(SearchRequest r) {
        Map<RoomType, List<Room>> map = new HashMap<>();

        map.put(RoomType.SINGLE, new ArrayList<>());
        map.put(RoomType.DOUBLE, new ArrayList<>());

        // go through all the rooms of this hotel and check its availability
        for (Room room : this.getRooms()) {
            // the room must not have date conflict
            if (room.isValidRequest(r)) {
                List<Room> roomList = map.get(room.getRoomType());
                roomList.add(room);
                map.put(room.getRoomType(), roomList);
            }
        }

        return map;
    }

    /**
     * Use case 1: SearchRequest with start date and end date, return RoomType and its left rooms
     * in this hotel. Firstly, check if given SearchRequest is cached in the LRUCache, if not,
     * invoke getAvailableRooms(r)
     * @param r
     * @return
     */
    public Map<RoomType, List<Room>> handleSearchRequst(SearchRequest r) {
        if (cache.containsKey(r)) {
            return cache.get(r);
        }
        // if current request does not exist in the LRUCache
        // traverse all the rooms to get the mapping info and
        // put this map into LRUCache with given SearchRequest
        Map<RoomType, List<Room>> map = getAvailableRooms(r);
        cache.put(r, map);
        return cache.get(r);
    }

    /**
     * Given the reservation request, try to find out rooms the request needs and update
     * room info both in hotel room list and LRUCache
     * Set up reservation on each room required by the reservation request
     * @param request
     * @return
     */
    public Reservation makeReservation(ReservationRequest request) {
        Reservation reservation = new Reservation(request.getStartDate(), request.getEndDate());

        SearchRequest search = new SearchRequest(request.getStartDate(), request.getEndDate());

        Map<RoomType, List<Room>>  availableRooms = getAvailableRooms(search);

        Map<RoomType, Integer> roomsNeeded = request.getRoomsNeeded();

        // traverse reservation request on each room type it needs and do reservation preparation for
        // each room of current room type
        for (Map.Entry<RoomType, Integer> entry : roomsNeeded.entrySet()) {
            RoomType roomType = entry.getKey();
            Integer roomCount = entry.getValue();

            List<Room> rooms = availableRooms.get(roomType); // current roomType room list

            // current reservation cannot make due to insufficient rooms left
            // still put current search and its result into cache for future use
            if (roomCount > rooms.size()) {
                cache.put(search, availableRooms);
                return null;
            }

            // if rooms are enough
            // add the current roomType room into reservation room list
            for (int i = 0; i < roomCount; i++) {
                Room room = rooms.remove(0);
                reservation.getRooms().add(room);
            }

            // update available rooms info
            availableRooms.put(roomType, rooms);

        }
        // store most recent info of available rooms and search in the cache
        cache.put(search, availableRooms);

        // make reservation on each selected room
        for (Room room : reservation.getRooms()) {
            room.makeReservation(reservation.getStartDate(), reservation.getEndDate());
        }

        return reservation;
    }


    public void cancelReservation(Reservation reservation) {
        for (Room room : reservation.getRooms()) {
            room.cancelReservation(reservation.getStartDate(), reservation.getEndDate());
        }
    }
}
