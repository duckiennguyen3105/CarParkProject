package com.fsoft.carparkproject.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@Table(name = "office")
@NoArgsConstructor
public class Office  {
    @Id
    @GeneratedValue(
            generator = "office_sequence",
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private String name;
    private String phone;
    private String price;
    @ManyToOne
    @JoinColumn(name = "trip_id",referencedColumnName = "id")
    private Trip trip;

    @ManyToOne
    @JoinColumn(name = "place_id", referencedColumnName = "id")
    private Place places;

    private LocalDate contractDeadline;

}
