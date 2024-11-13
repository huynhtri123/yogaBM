package org.example.yogabusinessmanagementweb.common.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Document(collection = "weighPlan") // MongoDB collection name
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class WeighPlan extends AbstractEntity<String> implements Serializable { // ID changed to String for MongoDB

    @Field("name")
    String name;

    @Field("description")
    String description;
}
