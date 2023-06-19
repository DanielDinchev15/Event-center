package dreamix.event.center.eventcenter.modules;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "events")
public class Event extends IdSubClass{

    private String eventName;
    private String date;
    private String location;


    @OneToMany(mappedBy="event")
    private Set<Tickets> tickets;

    @ManyToOne
    @JoinColumn(name = "venues_id", unique = true)
    private Venues venues;

    @ManyToOne
    @JoinColumn(name = "category_id", unique = true)
    private Categories category;

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }

    public Venues getVenues() {
        return venues;
    }

    public void setVenues(Venues venues) {
        this.venues = venues;
    }
}