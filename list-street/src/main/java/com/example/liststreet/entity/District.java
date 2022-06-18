package com.example.liststreet.entity;

import com.example.liststreet.entity.base.BaseEntity;
import com.example.liststreet.entity.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "districts")
public class District extends BaseEntity {
    @Id
    private String id;
    private String districtName;
    @OneToMany(mappedBy = "district", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Street> streetSet;
}
