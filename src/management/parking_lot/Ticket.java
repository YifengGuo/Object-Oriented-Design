package management.parking_lot;

/**
 * @author yifengguo
 */
public class Ticket {
    private Vehicle v;

    public Vehicle getV() {
        return v;
    }

    public Spot getSpot() {
        return spot;
    }

    public long getStartTime() {
        return startTime;
    }

    private Spot spot;
    private long startTime;

    public Ticket(Vehicle v, Spot s, long startTime) {
        this.v = v;
        this.spot = s;
        this.startTime = startTime;
    }

    @Override
    public String toString() {
        return v + " " + spot;
    }
}
