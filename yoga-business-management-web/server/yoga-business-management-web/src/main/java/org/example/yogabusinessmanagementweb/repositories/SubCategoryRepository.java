package org.example.yogabusinessmanagementweb.repositories;

import org.example.yogabusinessmanagementweb.common.entities.Category;
import org.example.yogabusinessmanagementweb.common.entities.SubCategory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubCategoryRepository extends MongoRepository<SubCategory, Long> {
    Optional<SubCategory> findById(Long id);
//    List<SubCategory> findAllByCategory(Category category);
    List<SubCategory> findAllByCategory(Category category);
}
