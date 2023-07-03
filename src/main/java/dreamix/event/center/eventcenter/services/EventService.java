package dreamix.event.center.eventcenter.services;

import dreamix.event.center.eventcenter.modules.Event;
import dreamix.event.center.eventcenter.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    @Autowired
    EventRepository eventRepository;

    public List<Event> getEvent() {
        return eventRepository.findAll();
    }

    public Event getEventById(Long id) {
        return eventRepository.findById(id);
    }

    public Event createEvent(Event event) {
        return eventRepository.create(event);
    }

    public Event updateEvent(Event existingEvent) {
        return eventRepository.update(existingEvent);
    }

    public void deleteEvent(Long id) {
        eventRepository.delete(id);
        getEvent();
    }

}
