package management.parking_lot;

/**
 * @author yifengguo
 */
public class BusSpot extends Spot {
    public BusSpot(int size, double hourlyRate, Level level) {
        this.size = VehicleType.BUS.getSize();
        this.hourlyRate = VehicleType.BUS.getHourlyRate();
        this.level = level;
    }
}
