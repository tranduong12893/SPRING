package com.example.shop.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String slug;
    private String description;
    private String detail;
    private Double price;
    private String Thumbnail;
    private String origin;
    @CreationTimestamp
    private Date createAt;
    @UpdateTimestamp
    private Date updateAt;
    @UpdateTimestamp
    private Date deleteAt;
    private int createByUser;
    private int updateByUser;
    private int deleteByUser;
    private int status;
}
