package org.example.yogabusinessmanagementweb.repositories;

import org.example.yogabusinessmanagementweb.common.entities.Lectures;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LecturesRepository extends MongoRepository<Lectures, Long> {
}
