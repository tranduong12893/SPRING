package com.example.shoppingcart.entity;

import com.example.shoppingcart.entity.base.BaseEntity;
import com.example.shoppingcart.entity.enums.ProductSimpleStatus;
import com.example.shoppingcart.entity.enums.ProductStatus;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Builder
@Entity
@Table(name = "products")
public class Product extends BaseEntity {

    @Id
    private String id;
    private String name;
    private String slug;
    private String description;
    @Column(columnDefinition = "text")
    private String detail;
    private BigDecimal price;
    @Column(columnDefinition = "text")
    private String Thumbnail;
    private String origin;
    private int qty;
    private ProductSimpleStatus status;

    public Product(){
        this.setCreatedAt(LocalDateTime.now());
        this.setUpdatedAt(LocalDateTime.now());
    }
}
