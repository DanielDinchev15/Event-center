package dreamix.event.center.eventcenter.converter;

import dreamix.event.center.eventcenter.dto.EventDto;
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
        Event map = modelMapper.map(eventDto, Event.class);
        Event existingEvent = eventService.getEventById(eventDto.getId());
        if(eventDto.getId() != null) {

            if (eventDto.getEventName() == null) {
                map.setEventName(existingEvent.getEventName());
            }
            if (eventDto.getLocation() == null) {
                map.setLocation(existingEvent.getLocation());
            }
            if (eventDto.getDate() == null) {
                map.setDate(existingEvent.getDate());
            }
        }
        return map;
    }
}
