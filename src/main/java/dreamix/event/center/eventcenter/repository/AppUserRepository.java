package dreamix.event.center.eventcenter.repository;

import dreamix.event.center.eventcenter.modules.AppUser;
import org.springframework.stereotype.Repository;

@Repository
public class AppUserRepository extends ParentRepository<AppUser> {
    public Class<AppUser> getEntityClass() {
        return AppUser.class;
    }
}

