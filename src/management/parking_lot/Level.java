package management.parking_lot;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yifengguo
 */
public class Level {
    private List<Spot> spots;
    private int availableSpots;

    private static final int DEFAULT_BUS_NUM = 10;
    private static final int DEFAULT_CAR_NUM = 30;
    private static final int DEFAULT_MOTORCYCLE_NUM = 10;

    /**
     * constructor of Level
     * by default, we have 10 bus spots, 10 motorcycle spots and 30 car spots in each level
     */
    public Level() {
        spots = new ArrayList<>();
        for (int i = 0; i < DEFAULT_BUS_NUM; i ++) {
            spots.add(new BusSpot(this));
        }
        for (int i = 0; i < DEFAULT_CAR_NUM; i++) {
            spots.add(new CarSpot(this));
        }
        for (int i = 0; i < DEFAULT_MOTORCYCLE_NUM; i++) {
            spots.add(new MotorcycleSpot(this));
        }
    }

    public List<Spot> getSpots() {
        return spots;
    }

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
            if (s.isAvailable() && s.size == v.getSize()) {
                res = s;
            } else if (s.isAvailable() && s.size > v.getSize()) {
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
