package org.example.yogabusinessmanagementweb.repositories;

import org.example.yogabusinessmanagementweb.common.entities.Sections;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionsRepository extends MongoRepository<Sections, Long> {
}
