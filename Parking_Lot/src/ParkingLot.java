import java.util.*;

public class ParkingLot {
    private List<Level> levels;
    private float hourlyRate;

    public ParkingLot(List<Level> levels, float hourlyRate) {
        this.levels = levels;
        this.hourlyRate = hourlyRate;
    }

    public int getAvailableCount() {
        int total = 0;
        for (Level l : levels) {
            total += l.getAvailableCount();
        }
        return total;
    }

    public Ticket parkVehicle(Vehicle v) throws ParkingLotFullException {
        for (Level l : levels) {
            List<Spot> spots = l.findSpotsForVehicle(v);
            if (spots != null) {
                for (Spot s : spots) s.takeSpot();
                return TicketFactory.createTicket(v, spots);
            }
        }
        throw new ParkingLotFullException("No spot available");
    }

    public void clearSpot(Ticket t) throws InvalidTicketException {
        if (t == null) throw new InvalidTicketException("Invalid ticket");

        for (Spot s : t.getSpots()) {
            s.leaveSpot();
        }
    }

    public float calculatePrice(Ticket t) {
        long duration = System.currentTimeMillis() - t.getStartTime();
        float hours = duration / (1000f * 3600f);
        return Math.max(1.0f, hours * hourlyRate);
    }
}
