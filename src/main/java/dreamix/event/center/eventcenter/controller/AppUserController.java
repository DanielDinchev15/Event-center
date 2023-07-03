package dreamix.event.center.eventcenter.controller;

import dreamix.event.center.eventcenter.modules.AppUser;
import dreamix.event.center.eventcenter.services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appUser")
public class AppUserController {


    @Autowired
    private AppUserService appUserService;

    @GetMapping("/all")
    public List<AppUser> getAllAppUser() {
        return appUserService.getAppUser();
    }

    @GetMapping("/appUser/{id}")
    public AppUser getAppUser(@PathVariable Long id) {
        return appUserService.getAppUserById(id);
    }

    @PostMapping("/add")
    public AppUser createAppUser(@RequestBody AppUser appUser) {
        return appUserService.createAppUser(appUser);
    }

    @PutMapping("/update/")
    public AppUser updateAppUser(@RequestBody AppUser existingAppUser) {
        return appUserService.updateAppUser(existingAppUser);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAppUser(@PathVariable Long id) {
        appUserService.deleteAppUser(id);
    }
}

