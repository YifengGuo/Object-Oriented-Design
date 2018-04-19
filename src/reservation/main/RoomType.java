package reservation.main;

/**
 * Created by guoyifeng on 4/18/18.
 */
public enum RoomType {
    SINGLE(1),
    DOUBLE(2);

    private int capacity;

    RoomType(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return this.capacity;
    }
}
