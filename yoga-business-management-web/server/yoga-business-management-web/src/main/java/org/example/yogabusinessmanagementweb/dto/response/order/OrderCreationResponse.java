package org.example.yogabusinessmanagementweb.dto.response.order;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.yogabusinessmanagementweb.dto.response.cartitem.CartItemResponse;

import java.math.BigDecimal;
import java.util.List;

@Data
@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class OrderCreationResponse {
    Long id;
    int totalItem;
    BigDecimal totalPrice;
    List<CartItemResponse> cartItem;
}
