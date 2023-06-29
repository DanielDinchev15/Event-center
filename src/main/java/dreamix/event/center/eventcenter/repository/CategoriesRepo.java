package dreamix.event.center.eventcenter.repository;

import dreamix.event.center.eventcenter.modules.Categories;
import org.springframework.stereotype.Repository;

@Repository
public class CategoriesRepo extends ParentRepo<Categories>{
    @Override
    public Class<Categories> getEntityName() {
        return Categories.class;
    }
}
