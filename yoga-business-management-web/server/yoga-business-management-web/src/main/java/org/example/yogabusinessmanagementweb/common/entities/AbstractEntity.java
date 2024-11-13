package org.example.yogabusinessmanagementweb.common.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
@Document
public abstract class AbstractEntity<T extends Serializable> implements Serializable {

    @Id
    T id; // T thường là String hoặc ObjectId cho MongoDB

    @CreatedBy
    String createdBy;

    @LastModifiedBy
    String updatedBy;

    @CreatedDate
    Date createdAt;

    @LastModifiedDate
    Date updatedAt;
}
