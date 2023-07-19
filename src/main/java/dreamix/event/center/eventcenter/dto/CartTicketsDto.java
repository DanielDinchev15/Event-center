package dreamix.event.center.eventcenter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartTicketsDto {

    private CartDto cart;
    private TicketDto tickets;
    private Integer quantity;

}

