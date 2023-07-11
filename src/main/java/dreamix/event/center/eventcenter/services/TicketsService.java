package dreamix.event.center.eventcenter.services;

import dreamix.event.center.eventcenter.modules.Tickets;
import dreamix.event.center.eventcenter.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TicketsService {

    @Autowired
    TicketRepository ticketRepository;

    public List<Tickets> getTickets() {
        return ticketRepository.findAll();
    }
    public Tickets getTicketById(Long id){
        return ticketRepository.findById(id);
    }

    public Tickets createTicket(Tickets tickets){
        return ticketRepository.create(tickets);
    }
    public Tickets updateTicket(Tickets existingTicket) {
        return ticketRepository.update(existingTicket);
    }
    public void deleteTicket(Long id){
        ticketRepository.delete(id);
        getTickets();
    }
}
