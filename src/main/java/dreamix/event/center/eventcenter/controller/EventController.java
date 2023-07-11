package dreamix.event.center.eventcenter.controller;

import dreamix.event.center.eventcenter.modules.Event;
import dreamix.event.center.eventcenter.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {


    @Autowired
    private EventService eventService;

    @GetMapping("/all")
    public List<Event> getAllEvent() {
        return eventService.getEvent();
    }

    @GetMapping("/event/{id}")
    public Event getEvent(@PathVariable Long id) {
        return eventService.getEventById(id);
    }

    @PostMapping("/add")
    public Event createEvent(@RequestBody Event event) {
        return eventService.createEvent(event);
    }

    @PutMapping("/update/")
    public Event updateEvent(@RequestBody Event existingEvent) {
        return eventService.updateEvent(existingEvent);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
    }
}
