package dreamix.event.center.eventcenter.modules;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tickets {
    @Id
    @Column(name = "ticket_id", nullable = false)
    private Long ticket_id;
    private int price;
    private int seatNumber;
  

}
