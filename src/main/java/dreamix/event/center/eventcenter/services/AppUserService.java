package dreamix.event.center.eventcenter.services;

import dreamix.event.center.eventcenter.modules.AppUser;
import dreamix.event.center.eventcenter.repository.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserService {
    @Autowired
    AppUserRepo appUserRepo;

    public void getAppUser() {
        for (AppUser appUser : appUserRepo.findAll()) {
            System.out.println(appUser.getUsername());
        }
    }
    public void getAppUserById(Long id){
        AppUser appUser =  appUserRepo.findById(id);
        System.out.println(appUser.getUsername());
    }

    public void createAppUser(AppUser appUser){
        appUserRepo.create(appUser);
    }
    public void updateAppUser(AppUser existingAppUser) {
        appUserRepo.update(existingAppUser);
        getAppUser();
    }
    public void deleteAppUser(Long id){
        appUserRepo.delete(id);
        getAppUser();
    }
}
