package dreamix.event.center.eventcenter.repository;

import dreamix.event.center.eventcenter.modules.Cart;
import dreamix.event.center.eventcenter.modules.Categories;
import dreamix.event.center.eventcenter.modules.Event;
import org.springframework.stereotype.Repository;

@Repository
public class CategoriesRepository extends ParentRepository<Categories> {
    @Override
    public Class<Categories> getEntityClass() {
        return Categories.class;
    }
}
