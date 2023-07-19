package dreamix.event.center.eventcenter.controller;

import dreamix.event.center.eventcenter.converter.VenueConverter;
import dreamix.event.center.eventcenter.dto.VenueDto;
import dreamix.event.center.eventcenter.services.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/venues")
public class VenueController {
    @Autowired
    private VenueService venueService;
    @Autowired
    private VenueConverter venueConverter;

    @GetMapping("/all")
    public List<VenueDto> getAllVenues() {
        return venueService.getVenue().stream().map(appUser -> venueConverter.convertEntityToDto(appUser)).collect(Collectors.toList());
    }

    @GetMapping("/venues/{id}")
    public VenueDto getVenue(@PathVariable Long id) {
        if (venueService.getVenuesById(id) == null) {
            return null;
        }
        return venueConverter.convertEntityToDto(venueService.getVenuesById(id));
        }
        @PostMapping("/add")
        public VenueDto createVenue(@RequestBody VenueDto venueDto) {
            return venueConverter.convertEntityToDto(venueService.createVenue(venueConverter.convertDtoToEntity(venueDto)));
        }

        @PutMapping("/update/")
        public VenueDto updateVenue(@RequestBody VenueDto venueDto) {
            return venueConverter.convertEntityToDto(venueService.updateVenue(venueConverter.convertDtoToEntity(venueDto)));
        }

        @DeleteMapping("/delete/{id}")
        public void deleteVenue(@PathVariable Long id) {
            venueService.deleteVenue(id);
        }
}
