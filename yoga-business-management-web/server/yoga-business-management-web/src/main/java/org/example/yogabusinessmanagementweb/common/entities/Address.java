package org.example.yogabusinessmanagementweb.common.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.example.yogabusinessmanagementweb.common.Enum.EAddress;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "addresses")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class Address extends AbstractEntity<String> { // ID có thể là String hoặc ObjectId
    String houseNumber;
    String street;
    String district;
    String city;
    EAddress status; // Enum được lưu dưới dạng String trong MongoDB

    String nameDelivery;
    String phoneNumberDelivery;
}
