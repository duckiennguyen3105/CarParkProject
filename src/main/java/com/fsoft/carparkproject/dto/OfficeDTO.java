package com.fsoft.carparkproject.dto;

import com.fsoft.carparkproject.model.Office;
import com.fsoft.carparkproject.model.Place;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
@Data
@NoArgsConstructor
public class OfficeDTO {
    private Long id;
    private String name;

    public OfficeDTO(Office office) {
        this.name = office.getName();
        this.phone = office.getPhone();
        this.price = office.getPrice();
        this.place_id = office.getPlaces().getId();
        this.contractDeadline = office.getContractDeadline();
        this.trip_id = office.getTrip().getId();
    }
    private Long trip_id;

    private String phone;
    private String price;
    private Long place_id;
    private LocalDate contractDeadline;

}
