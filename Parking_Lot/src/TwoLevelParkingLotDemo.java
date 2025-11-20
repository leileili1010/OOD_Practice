import java.util.*;

public class TwoLevelParkingLotDemo {

    public static void main(String[] args) throws Exception {

        // 1. Create spots
        List<Spot> row1Spots = new ArrayList<>();
        for (int i = 0; i < 5; i++) row1Spots.add(new Spot(i, SpotType.LARGE));

        List<Spot> row2Spots = new ArrayList<>();
        for (int i = 0; i < 3; i++) row2Spots.add(new Spot(100+i, SpotType.MEDIUM));
        for (int i = 0; i < 2; i++) row2Spots.add(new Spot(200+i, SpotType.LARGE));

        // 2. Create rows
        Row row1 = new Row(row1Spots);
        Row row2 = new Row(row2Spots);

        // 3. Create level
        Level level = new Level(Arrays.asList(row1, row2));

        // 4. Create parking lot
        ParkingLot lot = new ParkingLot(Arrays.asList(level), 3.0f);

        System.out.println("Initial available spots: " + lot.getAvailableCount());

        // 5. Park vehicles
        Ticket tm = lot.parkVehicle(new Motorcycle());
        System.out.println("Motorcycle parked. Spots left: " + lot.getAvailableCount());

        Ticket tc = lot.parkVehicle(new Car());
        System.out.println("Car parked. Spots left: " + lot.getAvailableCount());

        Ticket tb = lot.parkVehicle(new Bus());
        System.out.println("Bus parked. Spots left: " + lot.getAvailableCount());

        // Sleep for test
        Thread.sleep(2000);

        lot.clearSpot(tm);
        System.out.println("Motorcycle price: $" + lot.calculatePrice(tm));

        lot.clearSpot(tb);
        System.out.println("Bus price: $" + lot.calculatePrice(tb));

        lot.clearSpot(tc);
        System.out.println("Car price: $" + lot.calculatePrice(tc));

        System.out.println("Final available spots: " + lot.getAvailableCount());
        System.out.println("Demo finished!");
    }
}
