package management.parking_lot;

/**
 * @author yifengguo
 */
public class MotorcycleSpot extends Spot {
    public MotorcycleSpot(int size, double hourlyRate, Level level) {
        this.size = VehicleType.MOTORCYCLE.getSize();
        this.hourlyRate = VehicleType.MOTORCYCLE.getHourlyRate();
        this.level = level;
    }
}