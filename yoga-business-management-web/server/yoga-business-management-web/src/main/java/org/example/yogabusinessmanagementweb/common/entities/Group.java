package org.example.yogabusinessmanagementweb.common.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;

@Document(collection = "groups")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class Group extends AbstractEntity<String> { // ID chuyển sang String cho MongoDB
    String name;
    String description;
    int kind;

    @DBRef // Tham chiếu đến danh sách document GroupHasUser
    List<GroupHasUser> groupHasUsers;

    @DBRef // Tham chiếu đến danh sách document GroupHasPermission
    List<GroupHasPermission> groupHasPermissions;
}
