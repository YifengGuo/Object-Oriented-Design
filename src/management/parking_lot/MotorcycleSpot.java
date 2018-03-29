package management.parking_lot;

/**
 * @author yifengguo
 */
public class MotorcycleSpot extends Spot {
    public MotorcycleSpot(Level l) {
        super(l);
        this.size = VehicleType.MOTORCYCLE.getSize();
        this.hourlyRate = VehicleType.MOTORCYCLE.getHourlyRate();
    }

    public String toString() {
        return "MotorcycleSpot: " + this.size + " "+ this.hourlyRate +"\n";
    }
}