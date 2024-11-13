package org.example.yogabusinessmanagementweb.common.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Document(collection = "users") // MongoDB collection for User
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class User extends AbstractEntity<String> implements UserDetails, Serializable { // ID changed to String for MongoDB

    @Field("username")
    String username;

    @Field("password")
    String password;

    @Field("phone")
    String phone;

    @Field("gender")
    String gender;

    @Field("email")
    String email;

    @Field("fullname")
    String fullname;

    @Field("dateOfBirth")
    Date dateOfBirth;

    @Field("imagePath")
    String imagePath;

    @Field("roles")
    String roles;

    @Field("status")
    boolean status;

    // MongoDB doesn't support OneToMany relationships the same way, so you store the user addresses with DBRef (similar to foreign key)
    @DBRef
    List<Address> addresses;

    // GroupHasUser will also be stored in MongoDB as embedded documents, not as a relational join
    @DBRef
    List<GroupHasUser> groupHasUsers;

    @DBRef
    Wishlist wishlist;

    @DBRef
    Token token;

    @DBRef
    List<UserHasYogaWorkout> yogaWorkouts;

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(roles)); // Convert role to GrantedAuthority for MongoDB
    }
}
