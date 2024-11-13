package org.example.yogabusinessmanagementweb.common.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.example.yogabusinessmanagementweb.common.Enum.EStatusOrder;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Document(collection = "orders")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class Order extends AbstractEntity<String> implements Serializable {
    Date deliveryDate;
    BigDecimal totalPrice;
    int totalItem;

    // Lưu trực tiếp enum dưới dạng String
    EStatusOrder eStatusOrder;

    @DBRef
    private Payment payment;

    Date orderDate;

    @DBRef
    User user;

    @DBRef
    private Address address;

    @DBRef
    List<OrderItem> orderItems;
}

