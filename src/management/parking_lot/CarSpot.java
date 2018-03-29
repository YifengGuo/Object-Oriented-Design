package management.parking_lot;

/**
 * @author yifengguo
 */
public class CarSpot extends Spot {
    public CarSpot(int size, double hourlyRate, Level level) {
        this.size = VehicleType.CAR.getSize();
        this.hourlyRate = VehicleType.CAR.getHourlyRate();
        this.level = level;
    }
}
