package dreamix.event.center.eventcenter.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUserDTO {
    private Long id;
    private String username;
    private String email;
    private String password;
}