package elevator.main;

/**
 * Created by guoyifeng on 3/28/18.
 */
public abstract class Request {
    protected int level;
    public Request(int level) {
        this.level = level; // request form which level
    }
}
