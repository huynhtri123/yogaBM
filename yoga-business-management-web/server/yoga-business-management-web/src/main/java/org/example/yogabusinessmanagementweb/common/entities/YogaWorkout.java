package org.example.yogabusinessmanagementweb.common.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.List;

@Document(collection = "yogaworkout") // MongoDB collection name
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class YogaWorkout extends AbstractEntity<String> implements Serializable { // ID type is typically String in MongoDB

    String name;
    String description;
    int duration;
    String imagePath;
    String instruction;
    Integer level;
    String videoPath;

    // Embedding the UserHasYogaWorkout directly or storing references
    // Option 1: Embedding (if you want to include related data within YogaWorkout)
    @Field("user_has_yoga_workouts")
    List<UserHasYogaWorkout> yogaWorkouts;

    // Option 2: Referencing (if you just want to store the references/IDs to UserHasYogaWorkout)
    // @DBRef("user_has_yoga_workouts")
    // List<UserHasYogaWorkout> yogaWorkouts;
}
