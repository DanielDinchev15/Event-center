package dreamix.event.center.eventcenter.converter;

import dreamix.event.center.eventcenter.dto.AppUserDTO;
import dreamix.event.center.eventcenter.modules.AppUser;
import dreamix.event.center.eventcenter.services.AppUserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppUserConverter {


    @Autowired
    private AppUserService appUserService;


    public AppUserDTO convertEntityToDto(AppUser appUser){
        ModelMapper modelMapper = new ModelMapper();
        TypeMap<AppUser, AppUserDTO> typeMap = modelMapper.createTypeMap(AppUser.class, AppUserDTO.class);
        typeMap.addMappings(mapper -> mapper.skip((AppUserDTO::setPassword)));
        return modelMapper.map(appUser, AppUserDTO.class);
    }

    public AppUser convertDtoToEntity(AppUserDTO appUserDTO){
        ModelMapper modelMapper = new ModelMapper();
        AppUser map = modelMapper.map(appUserDTO, AppUser.class);
        AppUser existingAppUser = appUserService.getAppUserById(appUserDTO.getId());
        if(appUserDTO.getId() != null) {

            if (appUserDTO.getUsername() == null) {
                map.setUsername(existingAppUser.getUsername());
            }
            if (appUserDTO.getEmail() == null) {
                map.setEmail(existingAppUser.getEmail());
            }
            if (appUserDTO.getPassword() == null) {
                map.setPassword(existingAppUser.getPassword());
            }
        }
        return map;
    }
}

