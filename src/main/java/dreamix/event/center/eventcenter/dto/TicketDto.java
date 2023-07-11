package dreamix.event.center.eventcenter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketDto {
    private Long id;
    private int price;
    private int seatNumber;
    private String payment;
    private String boughtAt;
}
