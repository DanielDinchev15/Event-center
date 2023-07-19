package dreamix.event.center.eventcenter.converter;

import dreamix.event.center.eventcenter.dto.CartDto;
import dreamix.event.center.eventcenter.modules.Cart;
import dreamix.event.center.eventcenter.services.CartService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CartConverter {

    @Autowired
    private CartService cartService;
    @Autowired
    private AppUserConverter appUserConverter;
    public CartDto convertEntityToDto(Cart cart) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(cart, CartDto.class);
    }

    public Cart convertDtoToEntity(CartDto cartDto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(cartDto, Cart.class);
    }
}
