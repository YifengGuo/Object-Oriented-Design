package elevator.main;

/**
 * Created by guoyifeng on 3/28/18.
 */
public class ExternalRequest extends Request {
    private Direction d;

    public ExternalRequest(int level, Direction d) {
        super(level);
        this.d = d;
    }

    public Direction getD() {
        return this.d;
    }
}
