package management.parking_lot;

/**
 * @author yifengguo
 */
public class BusSpot extends Spot {
    public BusSpot(Level l) {
        super(l);
        this.size = VehicleType.BUS.getSize();
        this.hourlyRate = VehicleType.BUS.getHourlyRate();
    }

    public String toString() {
        return "BusSpot: " + this.size + " "+ this.hourlyRate +"\n";
    }
}
