package dreamix.event.center.eventcenter.converter;

import dreamix.event.center.eventcenter.dto.CartDto;
import dreamix.event.center.eventcenter.dto.TicketDto;
import dreamix.event.center.eventcenter.modules.Cart;
import dreamix.event.center.eventcenter.modules.Tickets;
import dreamix.event.center.eventcenter.services.TicketsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TicketConverter {
    @Autowired
    private TicketsService ticketsService;
    public TicketDto convertEntityToDto(Tickets tickets) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(tickets, TicketDto.class);
    }

    public Tickets convertDtoToEntity(TicketDto ticketDto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(ticketDto, Tickets.class);
    }
}
