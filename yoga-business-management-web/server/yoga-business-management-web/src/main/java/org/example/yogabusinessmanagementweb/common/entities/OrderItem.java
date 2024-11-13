package org.example.yogabusinessmanagementweb.common.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.example.yogabusinessmanagementweb.common.Enum.EStatusOrder;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "orderItems")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class OrderItem extends AbstractEntity<String> implements Serializable { // ID đổi sang String cho MongoDB

    String title;  // Sử dụng chuỗi thay vì @Column(name = "title")
    int quantity;

    @DBRef // Tham chiếu đến Rating document trong MongoDB
    Rating rating;

    EStatusOrder orderStatus;  // MongoDB sẽ lưu enum dưới dạng chuỗi

    Long totalPrice;

    @DBRef // Tham chiếu đến Product document trong MongoDB
    Product product;
}
