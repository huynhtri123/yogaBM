package org.example.yogabusinessmanagementweb.common.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.math.BigDecimal;
import java.util.List;

@Document(collection = "carts")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class Cart extends AbstractEntity<String> { // ID chuyển sang String cho MongoDB
    int totalItem;
    BigDecimal totalPrice;

    @DBRef // Tham chiếu đến document User
    User user;

    @DBRef // Tham chiếu đến danh sách document CartItem
    List<CartItem> cartItems;
}
