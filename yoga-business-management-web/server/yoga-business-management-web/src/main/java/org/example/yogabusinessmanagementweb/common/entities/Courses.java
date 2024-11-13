package org.example.yogabusinessmanagementweb.common.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.math.BigDecimal;
import java.util.List;

@Document(collection = "courses")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class Courses extends AbstractEntity<String> { // ID chuyển sang String cho MongoDB
    String name;
    String instruction;
    String description;
    String duration;
    String imagePath;
    int level;
    String videoPath;
    BigDecimal price;

    @DBRef // Tham chiếu đến document Teacher
    Teacher teacher;

    @DBRef // Tham chiếu đến document Topic
    Topic topic;

    @DBRef // Tham chiếu đến danh sách document Sections
    List<Sections> sections;
}
