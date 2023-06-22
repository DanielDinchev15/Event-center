package dreamix.event.center.eventcenter.repository;

import dreamix.event.center.eventcenter.modules.Tickets;
import org.springframework.stereotype.Repository;

@Repository
public class TicketRepo extends ParentRepo<Tickets> {
    public TicketRepo() {
        type = "tickets";
    }
}