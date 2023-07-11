package dreamix.event.center.eventcenter.repository;

import dreamix.event.center.eventcenter.modules.AppUser;
import dreamix.event.center.eventcenter.modules.Cart;
import dreamix.event.center.eventcenter.modules.Event;
import org.springframework.stereotype.Repository;

@Repository
public class CartRepository extends ParentRepository<Cart> {
    @Override
    public Class<Cart> getEntityClass() {
        return Cart.class;
    }
}

