package org.example.yogabusinessmanagementweb.common.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.example.yogabusinessmanagementweb.common.Enum.EHealthyGoal;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.io.Serializable;

@Document(collection = "healthy_informations")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class HealthyInformation extends AbstractEntity<String> implements Serializable { // ID chuyển sang String cho MongoDB

    EHealthyGoal healthyGoal; // Enum sẽ tự động được lưu dưới dạng String trong MongoDB

    int age;
    Double bmi;
    Double bmr;
    Double weight;
    Double height;
    int mealPerDay;

    @DBRef // Tham chiếu đến document User
    User user;

    @DBRef // Tham chiếu đến document WeighPlan
    WeighPlan weighPlan;
}
