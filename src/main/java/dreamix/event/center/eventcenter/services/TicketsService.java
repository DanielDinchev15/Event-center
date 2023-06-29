package dreamix.event.center.eventcenter.services;

import dreamix.event.center.eventcenter.modules.Tickets;
import dreamix.event.center.eventcenter.repository.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class TicketsService {

    @Autowired
    private TicketRepo ticketRepo;


    public void getTickets() {
        for (Tickets tickets : ticketRepo.findAll()) {
            System.out.println(tickets.getPrice());
        }
    }
    public void getTicketsById(Long id){
            Tickets tickets = ticketRepo.findById(id);
            System.out.println(tickets.getBoughtAt());
        }

    public void createTickets(Tickets ticket){
        ticketRepo.create(ticket);
    }
    public void updateTickets(Tickets existingTicket) {
        ticketRepo.update(existingTicket);
        getTickets();
    }
    public void deleteTickets(Long id){
        ticketRepo.delete(id);
        getTickets();
    }
}
