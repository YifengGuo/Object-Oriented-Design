package management.parking_lot;

/**
 * @author yifengguo
 */
public class CarSpot extends Spot {
    public CarSpot(Level l) {
        super(l);
        this.size = VehicleType.CAR.getSize();
        this.hourlyRate = VehicleType.CAR.getHourlyRate();
    }

    public String toString() {
        return "CarSpot: " + this.size + " "+ this.hourlyRate +"\n";
    }
}
