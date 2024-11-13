package org.example.yogabusinessmanagementweb.common.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Document(collection = "products") // Chỉ định collection MongoDB
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class Product extends AbstractEntity<String> implements Serializable { // Chuyển ID thành String

    @Field("image_url") // Sử dụng @Field để ánh xạ tên trường cho MongoDB
    String imagePath;

    String status;

    @Field("price") // Tương tự như trên
    BigDecimal price;

    @Field("title") // Tương tự như trên
    String title;

    @DBRef  // Chuyển đổi @ManyToOne thành @DBRef trong MongoDB
    @Field("subCategory_id")
    SubCategory subCategory;

    @Field("average_rating")
    Double averageRating = 0.0;

    @Field("code")
    String code;

    @Field("brand")
    String brand;

    @Field("description")
    String description;

    @DBRef  // Chuyển đổi @OneToMany thành @DBRef trong MongoDB
    @Field("ratings")
    List<Rating> ratings;

    @Field("variants") // Sử dụng @Field để ánh xạ trường JSON
    Map<String, Map<String, String>> variants;
}
