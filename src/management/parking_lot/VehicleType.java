package management.parking_lot;

/**
 * @author yifengguo
 */
public enum VehicleType {
    BUS(3, 5.0),
    CAR(2, 3.0),
    MOTORCYCLE(1, 4.0);

    private int size;
    private double hourlyRate;

    VehicleType(int size, double hourlyRate) {
        this.size = size;
        this.hourlyRate = hourlyRate;
    }

    public int getSize() {
        return size;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }
}
