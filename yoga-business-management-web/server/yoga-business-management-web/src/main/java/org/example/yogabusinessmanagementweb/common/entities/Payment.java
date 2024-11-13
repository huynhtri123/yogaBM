package org.example.yogabusinessmanagementweb.common.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "payments") // Chỉ định collection MongoDB
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class Payment extends AbstractEntity<String> implements Serializable { // Chuyển ID sang String cho MongoDB

    String nameMethod;  // Tên phương thức thanh toán
}
