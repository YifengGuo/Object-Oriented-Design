package management.parking_lot;

import java.util.List;

/**
 * @author yifengguo
 */
public class Level {
    private List<Spot> spots;
    private int availableSpots;

    public int getAvailableSpots() {
        return availableSpots;
    }


    public int getAvailableCount() {
        int res = 0;
        for (Spot s: spots) {
            if (s.available) {
                res++;
            }
        }
        availableSpots = res;
        return res;
    }

    /**
     * first try to find spot that matches the vehicle
     * if not, try to find larger size spot for vehicle
     * @param v
     * @return
     */
    public Spot findAvailableSpotForVehicle(Vehicle v) {
        Spot res = null;
        Spot larger = null;
        for (Spot s : spots) {
            if (s.size == v.getSize()) {
                res = s;
            } else if (s.size > v.getSize()) {
                larger = s;
            }
        }
        if (res != null) {
            return res;
        } else if (larger != null) {
            return larger;
        } else {
            return null;
        }
    }

    public void updateAvailableCount() {
        int res = 0;
        for (Spot s : spots) {
            if (s.available) {
                res++;
            }
        }
        this.availableSpots = res;
    }
}
