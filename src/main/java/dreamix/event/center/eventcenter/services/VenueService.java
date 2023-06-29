package dreamix.event.center.eventcenter.services;

import dreamix.event.center.eventcenter.modules.Venues;
import dreamix.event.center.eventcenter.repository.VenueRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VenueService {
    @Autowired VenueRepo venueRepo;


    public void getVenue() {
        for (Venues venues : venueRepo.findAll()) {
            System.out.println(venues.getVenueType());
        }
    }
    public void getVenue(Long id){
        Venues venues =  venueRepo.findById(id);
        System.out.println(venues.getVenueType());
    }

    public void createVenue(Venues venues){
        venueRepo.create(venues);
    }
    public void updateVenue(Venues existingVenue) {
        venueRepo.update(existingVenue);
        getVenue();
    }
    public void deleteVenue(Long id){
        venueRepo.delete(id);
        getVenue();
    }
}
