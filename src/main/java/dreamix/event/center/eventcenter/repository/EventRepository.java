package dreamix.event.center.eventcenter.repository;

import dreamix.event.center.eventcenter.modules.Event;
import org.springframework.stereotype.Repository;

@Repository
public class EventRepository extends ParentRepository<Event> {
    @Override
    public Class<Event> getEntityName() {
        return Event.class;
    }
}