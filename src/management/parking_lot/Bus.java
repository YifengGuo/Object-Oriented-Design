package management.parking_lot;

/**
 * @author yifengguo
 */
public class Bus extends Vehicle{
    public Bus() {
        super(VehicleType.BUS.getSize());
    }

    @Override
    public int getSize() {
        return size;
    }
}
