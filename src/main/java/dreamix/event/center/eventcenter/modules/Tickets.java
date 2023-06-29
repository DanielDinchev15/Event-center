package dreamix.event.center.eventcenter.modules;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tickets")
public class Tickets extends IdSubClass{

    private int price;
    private int seatNumber;
    private String payment;
    private String boughtAt;

    @ManyToOne
    @JoinColumn(name = "app_user_id", unique = true)
    private AppUser appUser;

    @ManyToOne
    @JoinColumn(name = "event_id", unique = true)
    private Event event;

    @OneToMany(mappedBy = "tickets", cascade = CascadeType.ALL)
    private Set<CartTickets> cartTickets;
    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

}