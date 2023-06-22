package dreamix.event.center.eventcenter.repository;

import dreamix.event.center.eventcenter.modules.Event;
import dreamix.event.center.eventcenter.modules.Tickets;
import org.springframework.stereotype.Repository;

@Repository
public class EventRepo extends ParentRepo<Event> {
    public EventRepo() {
        type = "event";
    }
}