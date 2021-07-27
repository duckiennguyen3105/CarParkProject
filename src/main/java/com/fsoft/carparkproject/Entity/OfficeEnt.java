package com.fsoft.carparkproject.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table
@NoArgsConstructor
public class OfficeEnt {
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
    @JoinColumn(name = "tripEnt_id",referencedColumnName = "id")
    private TripEnt tripEnt;

    @ManyToOne
    @JoinColumn(name = "placeEnt_id", referencedColumnName = "id")
    private PlaceEnt places;

    private LocalDate contractDeadline;

}
