package management.parking_lot;

/**
 * @author yifengguo
 */
public class Car extends Vehicle{
    public Car() {
        super(VehicleType.CAR.getSize());
    }

    @Override
    public int getSize() {
        return size;
    }
}