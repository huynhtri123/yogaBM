package org.example.yogabusinessmanagementweb.common.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Document(collection = "token") // Chỉ định collection MongoDB
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class Token extends AbstractEntity<String> implements Serializable { // Sử dụng String cho ID

    @Field("username") // Đặt tên trường MongoDB
    String username;

    @Field("access_token") // Đặt tên trường MongoDB
    String accessToken;

    @Field("refresh_token") // Đặt tên trường MongoDB
    String refreshToken;

    @Field("otp") // Đặt tên trường MongoDB
    String OTP;
}
