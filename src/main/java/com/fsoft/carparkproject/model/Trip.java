package com.fsoft.carparkproject.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "trip")
@NoArgsConstructor
@Data
public class Trip {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private String name;
    @OneToMany(
            mappedBy = "trip"
    )
    private Collection<Office> offices;
}
