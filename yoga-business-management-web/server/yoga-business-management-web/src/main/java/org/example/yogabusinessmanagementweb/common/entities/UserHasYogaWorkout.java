package org.example.yogabusinessmanagementweb.common.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Document(collection = "userHasYogaWorkout") // MongoDB collection for UserHasYogaWorkout
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class UserHasYogaWorkout extends AbstractEntity<String> implements Serializable { // ID changed to String for MongoDB

    @DBRef // MongoDB equivalent of ManyToOne relation
    @Field("user_id")
    User user;

    @DBRef
    @Field("yogaworkout_id")
    YogaWorkout yogaWorkout;

    @Field("is_done")
    Boolean isDone;
}
