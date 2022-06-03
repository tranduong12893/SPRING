package com.example.shop.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fullName;
    private String password;
    private String email;
    private String phone;
    private String address;
    private LocalDateTime dob;
    @CreationTimestamp
    private Date createAt;
    @CreationTimestamp
    private Date updateAt;
    private int status;


}
