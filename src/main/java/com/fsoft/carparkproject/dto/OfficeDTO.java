package com.fsoft.carparkproject.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OfficeDTO {
    private Long id;
    private String name;

    private Long trip_id;

    private String phone;
    private String price;
    private Long place_id;
    private LocalDate contractDeadline;

}
