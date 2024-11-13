package org.example.yogabusinessmanagementweb.common.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.example.yogabusinessmanagementweb.common.Enum.EStatus;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "categories")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class Category extends AbstractEntity<String> implements Serializable {

    String urlImage;

    EStatus status = EStatus.ACTIVE; // Enum sẽ được lưu trực tiếp dưới dạng String trong MongoDB

    String name;
}
