package org.example.yogabusinessmanagementweb.common.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;

@Document(collection = "sections") // Chỉ định collection MongoDB
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class Sections extends AbstractEntity<String> { // Chuyển ID thành String

    @Field("title") // Đặt tên trường MongoDB
    String title;

    @DBRef // Sử dụng DBRef để tham chiếu các Lectures nếu cần thiết, hoặc sử dụng @Field nếu bạn lưu trữ tài liệu con
    @Field("lectures") // Đặt tên trường MongoDB
    List<Lectures> lectures;
}
