package dreamix.event.center.eventcenter.converter;

import dreamix.event.center.eventcenter.dto.CartDto;
import dreamix.event.center.eventcenter.dto.VenueDto;
import dreamix.event.center.eventcenter.modules.Cart;
import dreamix.event.center.eventcenter.modules.Venues;
import dreamix.event.center.eventcenter.services.VenueService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VenueConverter {
    @Autowired
    private VenueService venueService;
    public VenueDto convertEntityToDto(Venues venues) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(venues, VenueDto.class);
    }

    public Venues convertDtoToEntity(VenueDto venueDto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(venueDto, Venues.class);
    }
}
