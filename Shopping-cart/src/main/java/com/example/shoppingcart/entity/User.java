package com.example.shoppingcart.entity;

import com.example.shoppingcart.entity.base.BaseEntity;
import com.example.shoppingcart.entity.enums.UserStatus;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User extends BaseEntity {
    @Id
    private String id;
    private String fullName;
    private String password;
    private String email;
    private String phone;
    private String address;
    private Date dob;
    @Enumerated(EnumType.ORDINAL)
    private UserStatus status;

    public User(){
        this.setCreatedAt(LocalDateTime.now());
        this.setUpdatedAt(LocalDateTime.now());
    }


}
