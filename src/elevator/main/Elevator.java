package elevator.main;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by guoyifeng on 3/28/18.
 */
public class Elevator {
    private List<ElevatorButton> buttons;
    private PriorityQueue<Integer> upStops;
    private PriorityQueue<Integer> downStops;
    private Status status;
    private double limitWeight;
    private double currentWeight;
    int currentLevel;
    boolean isGateOpen;
    private static final int BUILDING_LEVEL = 20;

    public Elevator() {
        buttons = new ArrayList<>(BUILDING_LEVEL); // assume the building has 20 levels
        for (int i = 1; i <= BUILDING_LEVEL; i++) {
            buttons.add(new ElevatorButton(this, i));
        }
        upStops = new PriorityQueue<>(BUILDING_LEVEL);
        downStops = new PriorityQueue<>(BUILDING_LEVEL);
        status = Status.IDLE; // idle by default
        limitWeight = 1000; // 1000kg
        currentWeight = 0;
        currentLevel = 1; // at level 1 by default
        isGateOpen = false;
    }

    public double getLimitWeight() {
        return limitWeight;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public boolean isGateOpen() {
        return isGateOpen;
    }


    public void handleInternalRequest(InternalRequest r) {
        if (!isRequestValid(r)) {
            try {
                throw new InvalidRequestException("The request is invalid, please select a new level");
            } catch (InvalidRequestException e) {
                e.printStackTrace();
            }
        }
        if (this.status == Status.UP) {
            this.upStops.offer(r.level);
        } else {
            this.downStops.offer(r.level);
        }

    }

    public void handleExternalRequest(ExternalRequest r) {
        // priority is handled by ElevatorSystem, now elevator is only to handle this request
//        if (r.level > this.currentLevel) {
//            if (this.status == Status.UP) {
//                this.upStops.offer(r.level);
//            } else {
//                this.downStops.offer(r.level);
//            }
//        } else {
//            if (this.status == Status.DOWN) {
//                this.downStops.offer(r.level);
//            } else {
//                this.upStops.offer(r.level);
//            }
//        }
        if (r.getD() == Direction.UP && this.status == Status.UP) {
            this.upStops.offer(r.level);
        } else if (r.getD() == Direction.DOWN && this.status == Status.DOWN) {
            this.downStops.offer(r.level);
        } else if (r.getD() == Direction.DOWN && this.status == Status.UP) {
            this.downStops.offer(r.level);
        } else if (r.getD() == Direction.UP && this.status == Status.DOWN) {
            this.upStops.offer(r.level);
        }

    }

    private boolean isRequestValid(InternalRequest r) {
        if (this.status == Status.UP && r.level < this.currentLevel) {
            return false;
        } else if (this.status == Status.DOWN && r.level > this.currentLevel) {
            return false;
        }
        return true;
    }

    public double getCurrentWeight() {
        return currentWeight;
    }

    public void openGate() {
        isGateOpen = true;
        if (this.status == Status.UP) {
            this.currentLevel = this.upStops.poll();
        } else {
            this.currentLevel = this.downStops.poll();
        }
        // passengers reaching destination get off
        // passengers at this level go on
        // update weight
    }

    public void closeGate() {
        isGateOpen = false;
        // check weight
        if (this.currentWeight > this.limitWeight) {
            try {
                throw new OverweightException("Elevator is overweight, please leave");
            } catch (OverweightException e) {
                e.printStackTrace();
            }
        }

        // determine next movement
        if (this.status == Status.UP) { // if current moving direction is up
            if (!this.upStops.isEmpty()) {
                // continue to go up
            } else if (!this.downStops.isEmpty()) {
                this.status = Status.DOWN;
                // go down
            } else {
                this.status = Status.IDLE;
            }
        } else { // current status is down
            if (!this.downStops.isEmpty()) {
                // continue go down
            } else if (!this.upStops.isEmpty()) {
                this.status = Status.UP;
                // go up
            } else {
                this.status = Status.IDLE;
            }
        }
    }

    public Status getStatus() {
        return this.status;
    }

}
