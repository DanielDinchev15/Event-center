package dreamix.event.center.eventcenter.repository;

import dreamix.event.center.eventcenter.modules.Tickets;
import org.springframework.stereotype.Repository;

@Repository
public class TicketRepository extends ParentRepository<Tickets> {
    @Override
    public Class<Tickets> getEntityName() {
        return Tickets.class;
    }

}