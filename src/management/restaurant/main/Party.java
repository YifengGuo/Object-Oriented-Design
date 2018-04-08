package management.restaurant.main;

/**
 * Created by guoyifeng on 4/8/18.
 */

/**
 * represents a group of people
 * for ood, we had better consider less on the single person
 */
public class Party {
    private int num; // the number of people that come into the restaurant

    public int getNum() {
        return this.num;
    }

    public Party(int num) {
        this.num = num;
    }
}
