package management.parking_lot;

/**
 * @author yifengguo
 */
public class Motorcycle extends Vehicle{
    public Motorcycle() {
        super(VehicleType.MOTORCYCLE.getSize());
    }

    @Override
    public int getSize() {
        return size;
    }
}