package management.parking_lot;

/**
 * @author yifengguo
 */
public abstract class Spot {
    protected int size;
    protected double hourlyRate;
    protected boolean available;
    protected Level level;

    public boolean isAvailable() {
        return this.available;
    }
    public void takeSpot() {
        this.available = false;
    }
    public void leaveSpot() {
        this.available = true;
    }

}
