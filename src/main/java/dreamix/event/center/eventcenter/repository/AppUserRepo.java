package dreamix.event.center.eventcenter.repository;

import dreamix.event.center.eventcenter.modules.AppUser;
import org.springframework.stereotype.Repository;

@Repository
public class AppUserRepo extends ParentRepo<AppUser>{
    @Override
    public Class<AppUser> getEntityName() {
        return AppUser.class;
    }
}
