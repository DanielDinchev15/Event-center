package dreamix.event.center.eventcenter.modules;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "venues")
public class Venues extends IdSubClass {

    private String venueType;

    @JsonIgnore
    @OneToMany(mappedBy = "venues")
    private Set<Event> events;
}