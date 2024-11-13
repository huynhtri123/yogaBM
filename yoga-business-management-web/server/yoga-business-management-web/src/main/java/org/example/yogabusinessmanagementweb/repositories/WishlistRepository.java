package org.example.yogabusinessmanagementweb.repositories;

import org.example.yogabusinessmanagementweb.common.entities.Wishlist;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishlistRepository extends MongoRepository<Wishlist, Long> {
}
