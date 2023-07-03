package dreamix.event.center.eventcenter.services;


import dreamix.event.center.eventcenter.modules.Venues;
import dreamix.event.center.eventcenter.repository.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenueService {
    @Autowired
    VenueRepository venueRepository;

    public List<Venues> getVenue() {
        return venueRepository.findAll();
    }

    public Venues getVenuesById(Long id) {
        return venueRepository.findById(id);
    }

    public Venues createVenue(Venues venues) {
        return venueRepository.create(venues);
    }

    public Venues updateVenue(Venues existingVenue) {
        return venueRepository.update(existingVenue);
    }

    public void deleteVenue(Long id) {
        venueRepository.delete(id);
        getVenue();
    }
}
