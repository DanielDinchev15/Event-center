package dreamix.event.center.eventcenter.controller;


import dreamix.event.center.eventcenter.modules.Venues;
import dreamix.event.center.eventcenter.services.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/venues")
public class VenueController {
    @Autowired
    private VenueService venueService;

    @GetMapping("/all")
    public List<Venues> getAllVenues() {
        return venueService.getVenue();
    }

    @GetMapping("/venues/{id}")
    public Venues getVenue(@PathVariable Long id) {
        return venueService.getVenuesById(id);
    }

    @PostMapping("/add")
    public Venues createVenue(@RequestBody Venues venues) {
        return venueService.createVenue(venues);
    }

    @PutMapping("/update/")
    public Venues updateVenue(@RequestBody Venues existingVenue) {
        return venueService.updateVenue(existingVenue);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteVenue(@PathVariable Long id) {
        venueService.deleteVenue(id);
    }
}
