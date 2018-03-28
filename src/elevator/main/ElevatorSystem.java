package elevator.main;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guoyifeng on 3/28/18.
 */
public class ElevatorSystem {
    private List<Elevator> elevators;
    private static final int NUMBER_OF_ELEVATORS = 8;
    public ElevatorSystem() {
        elevators = new ArrayList<>(NUMBER_OF_ELEVATORS); // assume there are 8 elevators in the building
        for (int i = 0; i < NUMBER_OF_ELEVATORS; i++) {
            elevators.add(new Elevator());
        }
    }


    // apply priority rule here
    // determine which elevator handle this request
    public void handleExternalRequest(ExternalRequest r) {
        List<Elevator> sameDirectionElevators = getSameDirectionElevators(r);
        if (sameDirectionElevators.size() != 0) {
            Elevator taker = findClosestWithSameDirection(r, sameDirectionElevators);
            taker.handleExternalRequest(r);
            return;
        } else { // cannot find elevators in the same direction
                 // try to find idle ones
            List<Elevator> idles = findIdles();
            if (idles.size() != 0) {
                idles.get(0).handleExternalRequest(r);
                return;
            } else { // cannot find idles, try to find closest elevator among reverse direction
                Elevator taker = findCloestWithReverseDirection(r, elevators);
                taker.handleExternalRequest(r);
                return;
            }
        }
    }

    private List<Elevator> getSameDirectionElevators(ExternalRequest r) {
        List<Elevator> res = new ArrayList<>();
        Direction d = r.getD();
        for (Elevator e : elevators) {
            if (e.getStatus().toString().equals(d.toString())) {
                res.add(e);
            }
        }
        return res;
    }

    private Elevator findClosestWithSameDirection(ExternalRequest r, List<Elevator> list) {
        Elevator res = null;
        if (r.getD() == Direction.UP) { // need to guarantee r is higher than elevator
            int closest = Integer.MAX_VALUE;
            for (Elevator e : list) {
                int diff = r.level - e.currentLevel;
                if (diff >= 0 && diff < closest) {
                    closest = diff;
                    res = e;
                }
            }
            return res;
        } else {
            int closest = Integer.MAX_VALUE;
            for (Elevator e : list) {
                int diff = e.currentLevel - r.level;
                if (diff >= 0 && diff <= closest) {
                    closest = diff;
                    res = e;
                }
            }
        }
        return res;
    }

    private List<Elevator> findIdles() {
        List<Elevator> res = new ArrayList<>();
        for (Elevator e : elevators) {
            if (e.getStatus() == Status.IDLE) {
                res.add(e);
            }
        }
        return res;
    }

    private Elevator findCloestWithReverseDirection(ExternalRequest r, List<Elevator> list) {
        Elevator res = null;
        int closest = Integer.MAX_VALUE;
        for (Elevator e : list) {
            int diff = r.level - e.currentLevel;
            if (Math.abs(diff) < closest) {
                closest = diff;
                res = e;
            }
        }
        return res;
    }
}
