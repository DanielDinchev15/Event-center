package dreamix.event.center.eventcenter.converter;

import dreamix.event.center.eventcenter.dto.CartDto;
import dreamix.event.center.eventcenter.dto.EventDto;
import dreamix.event.center.eventcenter.modules.Cart;
import dreamix.event.center.eventcenter.modules.Event;
import dreamix.event.center.eventcenter.services.EventService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventConverter {
    @Autowired
    private EventService eventService;

    public EventDto convertEntityToDto(Event event) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(event, EventDto.class);
    }

    public Event convertDtoToEntity(EventDto eventDto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(eventDto, Event.class);
    }
}
