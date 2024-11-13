package org.example.yogabusinessmanagementweb.common.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Document(collection = "group_has_permissions")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class GroupHasPermission extends AbstractEntity<String> { // ID chuyển sang String cho MongoDB

    @DBRef // Tham chiếu đến document Group
    Group group;

    @DBRef // Tham chiếu đến document Permission
    Permission permission;
}
