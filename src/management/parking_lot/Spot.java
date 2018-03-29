package management.parking_lot;

/**
 * @author yifengguo
 */
public abstract class Spot {
    protected int size;
    protected double hourlyRate;
    protected boolean available = true;
    protected Level level;

    public Spot(Level l) {
        this.level = l;
    }

    public boolean isAvailable() {
        return this.available == true;
    }
    public void takeSpot() {
        this.available = false;
        level.updateAvailableCount();
    }
    public void leaveSpot() {
        this.available = true;
        level.updateAvailableCount();
    }

}
