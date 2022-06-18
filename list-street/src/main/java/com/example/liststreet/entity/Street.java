package com.example.liststreet.entity;

import com.example.liststreet.entity.base.BaseEntity;
import com.example.liststreet.entity.enums.StreetStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "streets")
public class Street extends BaseEntity {
    @Id
    private String id;
    private String streetName;
    private String districtId;
    @ManyToOne
    @JoinColumn(name = "street_id", referencedColumnName = "id", nullable = false)
    @JsonBackReference
    private District district;
    private Date foundingDate;
    private String description;
    @Enumerated(EnumType.ORDINAL)
    private StreetStatus status;
}
