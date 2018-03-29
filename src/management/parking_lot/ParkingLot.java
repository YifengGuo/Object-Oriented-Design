package management.parking_lot;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yifengguo
 * better implement ParkingLot as a Singleton
 */
public class ParkingLot {
    private List<Level> levels;
    private static final int LEVEL_NUMBER = 5;
    private static final ParkingLot INSTANCE = new ParkingLot();

    private ParkingLot() {
        levels = new ArrayList<>();
        for (int i = 0; i < LEVEL_NUMBER; i++) {
            levels.add(new Level());
        }

    }

    public static ParkingLot getInstance() {
        return INSTANCE;
    }

    public int getAvailableCount() {
        int res = 0;
        for (Level l : levels) {
            res += l.getAvailableCount();
        }
        return res;
    }

    private Spot findAvailableSpotForVehicle(Vehicle v) {
        int availableSpots = getAvailableCount();
        if (availableSpots == 0) {
            try {
                throw new FullSpotsException("The parking lot is full!");
            } catch (FullSpotsException e) {
                e.printStackTrace();
            }
        }
        Spot res = null;
        for (Level l : levels) {
            res = l.findAvailableSpotForVehicle(v);
            if (res != null) {
                break;
            }
        }
        if (res == null) {
            try {
                throw new NoSuitableSpotException("No suitable spots left for the vehicle");
            } catch (NoSuitableSpotException e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    public Ticket parkVehicle(Vehicle v) {
        Spot suitableSpot = findAvailableSpotForVehicle(v);
        long startTime = System.currentTimeMillis();
        Ticket res = new Ticket(v, suitableSpot, startTime);
        return res;
    }

    public void clearSpot(Ticket t) {
        t.getSpot().leaveSpot();
        t.getSpot().level.updateAvailableCount();
    }

    public double calculatePrice(Ticket t) {
        double res = 0;
        long endTime = System.currentTimeMillis();
        long duration = endTime - t.getStartTime();
        res = t.getSpot().hourlyRate * duration;
        return res;
    }

}
