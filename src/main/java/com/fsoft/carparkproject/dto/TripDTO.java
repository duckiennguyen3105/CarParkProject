package com.fsoft.carparkproject.dto;

import com.fsoft.carparkproject.model.Trip;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TripDTO {
    private Long id;
    private String name;

    public TripDTO(Trip trip) {
        this.id = trip.getId();
        this.name = trip.getName();
    }
}
