package management.parking_lot;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yifengguo
 */
public class Test {
    public static void main(String[] args) throws InterruptedException{
        ParkingLot pl = ParkingLot.getInstance();
        // test Levels and Spots
//        for (Level l : pl.getLevels()) {
//            for (Spot s : l.getSpots()) {
//                System.out.println(s);
//            }
//            System.out.println();
//        }

        Car c = new Car();
        System.out.println(pl.getAvailableCount());
        Ticket t = pl.parkVehicle(c);
        System.out.println(t);
        System.out.println(pl.getAvailableCount());
        Thread.sleep(1000);
        pl.clearSpot(t);
        System.out.println("The bill you need to pay is: " + pl.calculatePrice(t));
        System.out.println(pl.getAvailableCount());

        List<Vehicle> list = new ArrayList<>();
        for (int i = 0; i < 250; i++) {
            Car tmp = new Car();
            list.add(tmp);
        }
        for (int i = 0; i < list.size(); i++) {
            pl.parkVehicle(list.get(i));
            System.out.println(pl.getAvailableCount());
        }
//        Bus b = new Bus();
//        pl.parkVehicle(b);
//        Bus b2 = new Bus();
//        pl.parkVehicle(b2);
//        System.out.println(pl.getAvailableCount());
    }
}
