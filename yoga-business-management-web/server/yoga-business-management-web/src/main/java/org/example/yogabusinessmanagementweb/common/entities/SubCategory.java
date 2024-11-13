package org.example.yogabusinessmanagementweb.common.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.example.yogabusinessmanagementweb.common.Enum.EStatus;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Document(collection = "subCategory") // Chỉ định collection MongoDB
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class SubCategory extends AbstractEntity<String> implements Serializable { // Chuyển ID thành String

    @Field("name") // Đặt tên trường MongoDB
    String name;

    @DBRef // Sử dụng DBRef để tham chiếu đến Category
    @Field("category") // Đặt tên trường MongoDB
    Category category;

    @Field("status") // Đặt tên trường MongoDB
    EStatus status = EStatus.ACTIVE;
}
