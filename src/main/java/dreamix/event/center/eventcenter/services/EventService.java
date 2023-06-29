package dreamix.event.center.eventcenter.services;

import dreamix.event.center.eventcenter.modules.Event;
import dreamix.event.center.eventcenter.repository.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    @Autowired
    EventRepo eventRepo;

    public void getEvent() {
        for (Event event : eventRepo.findAll()) {
            System.out.println(event.getEventName());
        }
    }
    public void getEventById(Long id){
        Event event =  eventRepo.findById(id);
        System.out.println(event.getEventName());
    }

    public void createEvent(Event event){
        eventRepo.create(event);
    }
    public void updateEvent(Event existingEvent) {
        eventRepo.update(existingEvent);
        getEvent();
    }
    public void deleteEvent(Long id){
        eventRepo.delete(id);
        getEvent();
    }
}
