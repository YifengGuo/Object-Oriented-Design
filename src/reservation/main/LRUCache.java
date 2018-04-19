package reservation.main;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by guoyifeng on 4/18/18.
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

    public String printCache() {
        String res = "";

        for (Map.Entry<SearchRequest, Map<RoomType, List<Room>>> entry : super.entrySet()) {
            res += ("Request -> " + entry.getKey().toString()+ "\n");
            res += ("Corresponding Rooms -> " + printAllAvailableRooms(entry.getValue()) + "\n");
            res += "\n"
        }
        return res;
    }
}
