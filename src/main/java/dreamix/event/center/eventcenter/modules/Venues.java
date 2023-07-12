package dreamix.event.center.eventcenter.modules;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "venues")
public class Venues extends IdSubClass {

    private String venueType;


    @OneToMany(mappedBy = "venues")
    private List<Event> events;
}