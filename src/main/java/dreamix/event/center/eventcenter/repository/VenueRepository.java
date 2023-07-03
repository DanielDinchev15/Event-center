package dreamix.event.center.eventcenter.repository;

import dreamix.event.center.eventcenter.modules.Venues;
import org.springframework.stereotype.Repository;

@Repository
public class VenueRepository extends ParentRepository<Venues> {

    @Override
    public Class<Venues> getEntityName() {
        return Venues.class;
    }
}
