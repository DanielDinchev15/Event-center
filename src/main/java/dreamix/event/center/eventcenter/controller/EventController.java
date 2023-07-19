package dreamix.event.center.eventcenter.controller;

import dreamix.event.center.eventcenter.converter.EventConverter;
import dreamix.event.center.eventcenter.dto.EventDto;
import dreamix.event.center.eventcenter.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/events")
public class EventController {


    @Autowired
    private EventService eventService;
    @Autowired
    private EventConverter eventConverter;

    @GetMapping("/all")
    public List<EventDto> getAllEvent() {
        return eventService.getEvent().stream().map(event -> eventConverter.convertEntityToDto(event)).collect(Collectors.toList());
    }

    @GetMapping("/event/{id}")
    public EventDto getEvent(@PathVariable Long id) {
        if(eventService.getEventById(id) == null){
            return null;
        }
        return eventConverter.convertEntityToDto(eventService.getEventById(id));
    }


    @PostMapping("/add")
    public EventDto createEvent(@RequestBody EventDto eventDto) {
        return eventConverter.convertEntityToDto(eventService.createEvent(eventConverter.convertDtoToEntity(eventDto)));
    }

    @PutMapping("/update/")
    public EventDto updateEvent(@RequestBody EventDto eventDto) {
        return eventConverter.convertEntityToDto(eventService.updateEvent(eventConverter.convertDtoToEntity(eventDto)));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
    }
}
