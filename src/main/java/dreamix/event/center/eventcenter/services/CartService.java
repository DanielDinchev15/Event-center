package dreamix.event.center.eventcenter.services;

import dreamix.event.center.eventcenter.modules.Cart;
import dreamix.event.center.eventcenter.repository.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    @Autowired
    CartRepo cartRepo;

    public void getCart() {
        for (Cart cart : cartRepo.findAll()) {
            System.out.println(cart.getAppUser());
        }
    }
    public void getCartById(Long id){
        Cart cart =  cartRepo.findById(id);
        System.out.println(cart.getAppUser());
    }

    public void createCart(Cart cart){
        cartRepo.create(cart);
    }
    public void updateCart(Cart existingCart) {
        cartRepo.update(existingCart);
        getCart();
    }
    public void deleteCart(Long id){
        cartRepo.delete(id);
        getCart();
    }
}
