package dreamix.event.center.eventcenter.controller;

import dreamix.event.center.eventcenter.converter.AppUserConverter;
import dreamix.event.center.eventcenter.dto.AppUserDTO;
import dreamix.event.center.eventcenter.services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/appUser")
public class AppUserController {


    @Autowired
    private AppUserService appUserService;
    @Autowired
    private AppUserConverter appUserConverter;

    @GetMapping("/all")
    public List<AppUserDTO> getAllAppUser() {
        return appUserService.getAppUser().stream().map(appUser -> appUserConverter.convertEntityToDto(appUser)).collect(Collectors.toList());
    }
    @GetMapping("/{id}")
    public AppUserDTO getAppUser(@PathVariable Long id) {
        if(appUserService.getAppUserById(id) == null){
            return null;
        }
        return appUserConverter.convertEntityToDto(appUserService.getAppUserById(id));
    }
    @PostMapping("/add")
    public AppUserDTO createAppUser(@RequestBody AppUserDTO appUserDTO) {
        return appUserConverter.convertEntityToDto(appUserService.createAppUser(appUserConverter.convertDtoToEntity(appUserDTO)));
    }

    @PutMapping("/update")
    public AppUserDTO updateAppUser(@RequestBody AppUserDTO appUserDTO) {
        return appUserConverter.convertEntityToDto(appUserService.updateAppUser(appUserConverter.convertDtoToEntity(appUserDTO)));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAppUser(@PathVariable Long id) {
        appUserService.deleteAppUser(id);
    }
}

