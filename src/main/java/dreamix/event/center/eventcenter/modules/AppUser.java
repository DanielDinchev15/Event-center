package dreamix.event.center.eventcenter.modules;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "app_users")
public class AppUser extends IdSubClass {

    private String username;
    private String email;
    private String password;

    @OneToMany(mappedBy = "appUser")
    private List<Tickets> tickets;

    @OneToOne(mappedBy = "appUser", cascade = CascadeType.ALL)
    private Cart cart;
}