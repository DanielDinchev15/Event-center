package dreamix.event.center.eventcenter.repository;

import dreamix.event.center.eventcenter.modules.Cart;
import org.springframework.stereotype.Repository;

@Repository
public class CartRepository extends ParentRepository<Cart> {
    @Override
    public Class<Cart> getEntityName() {
        return Cart.class;
    }
}
