package management.parking_lot;

/**
 * @author yifengguo
 */
public abstract class Vehicle {
    protected int size;
    public Vehicle (int size){
        this.size = size;
    }
    public abstract int getSize();

    @Override
    public String toString() {
        return this.getClass().toString();
    }
}
