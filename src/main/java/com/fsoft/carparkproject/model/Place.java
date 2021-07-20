package com.fsoft.carparkproject.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@Table(name = "place")
public class Place {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    private String placeName;
    @OneToMany(
            mappedBy = "places"
    )
    private Collection<Office> offices;

}
