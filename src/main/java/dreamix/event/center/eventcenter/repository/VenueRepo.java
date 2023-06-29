package dreamix.event.center.eventcenter.repository;

import dreamix.event.center.eventcenter.modules.Venues;
import org.springframework.stereotype.Repository;

@Repository
public class VenueRepo extends ParentRepo<Venues>{

    @Override
    public Class<Venues> getEntityName() {
        return Venues.class;
    }
}
