package elevator.main;


/**
 * Created by guoyifeng on 3/28/18.
 */
public class ElevatorButton {
    private Elevator e;
    private int level;

    public ElevatorButton(Elevator e, int level) {
        this.e = e;
        this.level = level;
    }

    public InternalRequest pressButton(int level) {
        return new InternalRequest(level);
    }
}
