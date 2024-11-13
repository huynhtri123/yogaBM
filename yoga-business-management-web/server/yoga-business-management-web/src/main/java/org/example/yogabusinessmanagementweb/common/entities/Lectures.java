package org.example.yogabusinessmanagementweb.common.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "lectures")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class Lectures extends AbstractEntity<String> { // ID chuyển sang String cho MongoDB

    String title;
    String content;
    String videoPath;
    String duration; // phút
    String image;
}
