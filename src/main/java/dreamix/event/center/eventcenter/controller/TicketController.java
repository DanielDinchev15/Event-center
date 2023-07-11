package dreamix.event.center.eventcenter.controller;


import dreamix.event.center.eventcenter.modules.Tickets;
import dreamix.event.center.eventcenter.services.TicketsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    private TicketsService ticketsService;

    @GetMapping("/all")
    public List<Tickets> getAllTickets() {
        return ticketsService.getTickets();
    }

    @GetMapping("/tickets/{id}")
    public Tickets getTickets(@PathVariable Long id) {
        return ticketsService.getTicketById(id);
    }

    @PostMapping("/add")
    public Tickets createTicket(@RequestBody Tickets tickets) {
        return ticketsService.createTicket(tickets);
    }

    @PutMapping("/update/")
    public Tickets updateTicket(@RequestBody Tickets existingTicket) {
        return ticketsService.updateTicket(existingTicket);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTicket(@PathVariable Long id) {
        ticketsService.deleteTicket(id);
    }
}
