package org.example.yogabusinessmanagementweb.common.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Document(collection = "topic") // Chỉ định collection MongoDB
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class Topic extends AbstractEntity<String> implements Serializable { // Thay đổi kiểu ID thành String cho MongoDB

    @Field("name") // Đặt tên trường MongoDB
    String name;

    @Field("description") // Đặt tên trường MongoDB
    String description;
}
