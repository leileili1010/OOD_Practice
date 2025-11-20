import java.util.*;

public class Ticket {
    private String ticketId;
    private Vehicle vehicle;
    private List<Spot> spots;
    private long startTime;

    public Ticket(String id, Vehicle v, List<Spot> spots) {
        this.ticketId = id;
        this.vehicle = v;
        this.spots = spots;
        this.startTime = System.currentTimeMillis();
    }

    public List<Spot> getSpots() {
        return spots;
    }

    public long getStartTime() {
        return startTime;
    }
}
