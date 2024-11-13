package org.example.yogabusinessmanagementweb.common.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Document(collection = "temp") // Chỉ định collection MongoDB
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class Temp extends AbstractEntity<String> implements Serializable { // Chuyển ID thành String

    @Field("a") // Đặt tên trường MongoDB
    String a;

    @Field("b") // Đặt tên trường MongoDB
    String b;

    @Field("c") // Đặt tên trường MongoDB
    String c;

    @Field("d") // Đặt tên trường MongoDB
    String d;
}
