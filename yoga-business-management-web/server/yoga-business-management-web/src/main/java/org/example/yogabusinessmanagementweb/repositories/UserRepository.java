package org.example.yogabusinessmanagementweb.repositories;

import org.example.yogabusinessmanagementweb.common.entities.Token;
import org.example.yogabusinessmanagementweb.common.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    List<User> findAll();

    Optional<User> findByEmail(String email);
    Optional<User> findByPhone(String phone);
    Optional<User> findByUsername(String username);
    Optional<User> findByToken(Token token);
    Optional<User> findById(Long id);
}
