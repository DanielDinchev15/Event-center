package dreamix.event.center.eventcenter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDto {
    private Long id;
    private String eventName;
    private String date;
    private String location;
    private List<TicketDto> tickets;
    private VenueDto venue;
    private CategoriesDto category;


}
