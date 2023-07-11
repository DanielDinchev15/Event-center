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
@Table(name = "carts")
public class Cart extends IdSubClass {


    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    Set<CartTickets> cartTickets;

    @OneToOne
    @JoinColumn(name = "appUser_id", referencedColumnName = "id", unique = true)
    private AppUser appUser;

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }
}