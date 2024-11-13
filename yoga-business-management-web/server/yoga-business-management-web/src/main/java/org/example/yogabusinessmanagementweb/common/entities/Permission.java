package org.example.yogabusinessmanagementweb.common.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.io.Serializable;
import java.util.List;

@Document(collection = "permissions") // Chỉ định collection MongoDB
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class Permission extends AbstractEntity<String> { // Chuyển ID thành String

    String name;
    String description;
    String pCode;

    @DBRef // Đánh dấu quan hệ với một collection khác (tương đương với @OneToMany trong JPA)
    List<GroupHasPermission> groupHasPermissions;
}
