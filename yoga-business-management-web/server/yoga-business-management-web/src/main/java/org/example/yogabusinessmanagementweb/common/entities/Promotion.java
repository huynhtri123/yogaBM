package org.example.yogabusinessmanagementweb.common.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Date;

@Document(collection = "promotions") // Chỉ định collection MongoDB
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class Promotion extends AbstractEntity<String> implements Serializable { // Chuyển ID thành String

    @Field("start_date") // Đặt tên trường MongoDB
    Date startDate;

    @Field("end_date") // Đặt tên trường MongoDB
    Date endDate;

    @Field("percent") // Đặt tên trường MongoDB
    int percent;

    @DBRef  // Chuyển đổi @OneToOne thành @DBRef trong MongoDB
    @Field("product")
    Product product;
}
