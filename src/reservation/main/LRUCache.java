package reservation.main;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by guoyifeng on 4/18/18.<br>
 *
 * This LRUCache is to store mapping info between
 * SearchRequest and Map<RoomType, List<Room>>
 * Because when send SearchRequest to Hotel, Hotel will go through all the rooms to
 * check its availability. However, when making Reservation, to confirm Reservation,
 * Hotel will go through all the rooms again to check each room's availability if without
 * this LRUCache.<br>
 *
 * This LRUCache caches the available rooms' info of current SearchRequest, with this
 * LRUCache, Reservation making will be more efficient<br>
 *
 * The practice for this LRUCache in real life is that search frequency is much higher
 * than Reservation's
 *
 */
public class LRUCache extends LinkedHashMap<SearchRequest, Map<RoomType, List<Room>>> {
    private static final long serialVersionUID = 1L;
    private int capacity;

    public LRUCache(int capacity) {
        super(capacity);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<SearchRequest, Map<RoomType, List<Room>>> eldest) {
        return this.size() > capacity;
    }

    private String printAllAvailableRooms(Map<RoomType, List<Room>> rooms) {
        String res = "";
        for (Map.Entry<RoomType, List<Room>> entry : rooms.entrySet()) {
            res += "For room type: " + entry.getKey() + ", available rooms are: ";
            for (Room room : entry.getValue()) {
                res += room.getId() + "; ";
            }
            res += ". ";
        }
        return res;
    }

    @Override
    public String toString() {
        String res = "";
        for (Map.Entry<SearchRequest, Map<RoomType, List<Room>>> entry : super.entrySet()) {
            res += ("Request -> " + entry.getKey().toString()+ "\n");
            res += ("Corresponding Rooms -> " + printAllAvailableRooms(entry.getValue()) + "\n");
            res += "\n";
        }
        return res;
    }
}
