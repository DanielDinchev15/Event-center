package dreamix.event.center.eventcenter.controller;


import dreamix.event.center.eventcenter.modules.Cart;
import dreamix.event.center.eventcenter.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/all")
    public List<Cart> getAllCart() {
        return cartService.getCart();
    }

    @GetMapping("/cart/{id}")
    public Cart getCart(@PathVariable Long id) {
        return cartService.getCartById(id);
    }

    @PostMapping("/add")
    public Cart createCart(@RequestBody Cart cart) {
        return cartService.createCart(cart);
    }

    @PutMapping("/update/")
    public Cart updateCart(@RequestBody Cart existingCart) {
        return cartService.updateCart(existingCart);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCart(@PathVariable Long id) {
        cartService.deleteCart(id);
    }
}
