package org.example.yogabusinessmanagementweb.common.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Document(collection = "ratings") // Chỉ định collection MongoDB
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class Rating extends AbstractEntity<String> implements Serializable { // Chuyển ID thành String

    @Field("rate_point") // Đặt tên trường MongoDB
    int ratePoint;

    @Field("content") // Đặt tên trường MongoDB
    String content;
}
