import java.util.List;
import java.util.UUID;

public class TicketFactory {
    public static Ticket createTicket(Vehicle v, List<Spot> spots) {
        return new Ticket(UUID.randomUUID().toString(), v, spots);
    }
}
