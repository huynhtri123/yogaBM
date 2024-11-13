package org.example.yogabusinessmanagementweb.repositories;

import org.example.yogabusinessmanagementweb.common.entities.Cart;
import org.example.yogabusinessmanagementweb.common.entities.CartItem;
import org.example.yogabusinessmanagementweb.common.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends MongoRepository<Cart, String> {
    Optional<Cart> findCartByUser(User user);
    Optional<Cart> findCartById(Long id);
    Optional<Cart> findCartByCartItems(CartItem cartItem);
}
