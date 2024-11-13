package org.example.yogabusinessmanagementweb.common.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.List;

@Document(collection = "wishlist") // MongoDB collection name
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class Wishlist extends AbstractEntity<String> implements Serializable { // ID changed to String for MongoDB

    @DBRef // This indicates that this is a reference to another MongoDB document
    @Field("loved_products")
    List<Product> lovedProducts;
}
