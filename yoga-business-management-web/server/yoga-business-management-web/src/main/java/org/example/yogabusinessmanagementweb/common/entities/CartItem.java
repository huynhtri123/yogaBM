package org.example.yogabusinessmanagementweb.common.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.math.BigDecimal;
import java.util.Map;

@Document(collection = "cart_items")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class CartItem extends AbstractEntity<String> { // ID chuyển thành String cho MongoDB
    int quantity;

    BigDecimal totalPrice;

    @DBRef // Tham chiếu đến document Product
    Product product;

    Map<String, Map<String, String>> currentVariant; // Lưu trữ JSON trực tiếp trong MongoDB
}
