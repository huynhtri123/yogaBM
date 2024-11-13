package org.example.yogabusinessmanagementweb.repositories;

import org.example.yogabusinessmanagementweb.common.Enum.EStatus;
import org.example.yogabusinessmanagementweb.common.entities.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {
    Optional<Category> findById(Long id);
    Optional<Category> findByNameAndStatus(String name, EStatus status);
    Optional<Category> findByIdAndStatus(Long id, EStatus status);
}
