package org.example.yogabusinessmanagementweb.repositories;

import org.example.yogabusinessmanagementweb.common.entities.UserHasYogaWorkout;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserHasYogaWorkoutRepository extends MongoRepository<UserHasYogaWorkout, Long> {
}
