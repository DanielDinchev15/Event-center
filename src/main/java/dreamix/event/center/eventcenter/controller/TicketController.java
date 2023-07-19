package dreamix.event.center.eventcenter.controller;

import dreamix.event.center.eventcenter.converter.TicketConverter;
import dreamix.event.center.eventcenter.dto.TicketDto;
import dreamix.event.center.eventcenter.services.TicketsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    private TicketsService ticketsService;
    @Autowired
    private TicketConverter ticketConverter;

    @GetMapping("/all")
    public List<TicketDto> getAllTickets() {
        return ticketsService.getTickets().stream().map(tickets -> ticketConverter.convertEntityToDto(tickets)).collect(Collectors.toList());
    }

    @GetMapping("/tickets/{id}")
    public TicketDto getTickets(@PathVariable Long id) {
        if(ticketsService.getTicketById(id) == null){
            return null;
        }
        return ticketConverter.convertEntityToDto(ticketsService.getTicketById(id));
    }

    @PostMapping("/add")
    public TicketDto createTicket(@RequestBody TicketDto ticketDto) {
        return ticketConverter.convertEntityToDto(ticketsService.createTicket(ticketConverter.convertDtoToEntity(ticketDto)));
    }

    @PutMapping("/update/")
    public TicketDto updateTicket(@RequestBody TicketDto ticketDto) {
        return ticketConverter.convertEntityToDto(ticketsService.updateTicket(ticketConverter.convertDtoToEntity(ticketDto)));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTicket(@PathVariable Long id) {
        ticketsService.deleteTicket(id);
    }
}
