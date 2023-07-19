package dreamix.event.center.eventcenter.controller;

import dreamix.event.center.eventcenter.converter.CartConverter;
import dreamix.event.center.eventcenter.dto.CartDto;
import dreamix.event.center.eventcenter.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;
    @Autowired
    private CartConverter cartConverter;

    @GetMapping("/all")
    public List<CartDto> getAllCart() {
        return cartService.getCart().stream().map(cart -> cartConverter.convertEntityToDto(cart)).collect(Collectors.toList());
    }

    @GetMapping("/cart/{id}")
    public CartDto getCart(@PathVariable Long id) {
        return cartConverter.convertEntityToDto(cartService.getCartById(id));
    }

    @PostMapping("/add")
    public CartDto createCart(@RequestBody CartDto cartDto) {
        return cartConverter.convertEntityToDto(cartService.createCart(cartConverter.convertDtoToEntity(cartDto)));
    }

    @PutMapping("/update/")
    public CartDto updateCart(@RequestBody CartDto cartDto) {
        return cartConverter.convertEntityToDto(cartService.updateCart(cartConverter.convertDtoToEntity(cartDto)));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCart(@PathVariable Long id) {
        cartService.deleteCart(id);
    }
}
