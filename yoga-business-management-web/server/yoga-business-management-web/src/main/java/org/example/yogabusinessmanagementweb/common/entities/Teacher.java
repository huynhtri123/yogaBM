package org.example.yogabusinessmanagementweb.common.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Document(collection = "teacher") // Chỉ định collection MongoDB
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class Teacher extends AbstractEntity<String> implements Serializable { // Chuyển ID thành String

    @Field("full_name") // Đặt tên trường MongoDB
    String fullName;

    @Field("introduction") // Đặt tên trường MongoDB
    String introduction;

    @Field("description") // Đặt tên trường MongoDB
    String description;

    @Field("email") // Đặt tên trường MongoDB
    String email;

    @Field("phone_number") // Đặt tên trường MongoDB
    String phoneNumber;

    @Field("experience_years") // Đặt tên trường MongoDB
    int experienceYears;

    @Field("profile_picture") // Đặt tên trường MongoDB
    String profilePicture;
}
